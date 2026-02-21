package ru.kvmsoft.features.events.imp.domain

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.imp.mapper.Mapper.mapToEventsItems
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenViewState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class EventsListScreenInteractor(
    private val getEventsUseCase: GetEventsUseCase,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val encryptedDataStore: EncryptedDataStore,
    private val getAsModeUseCase: GetAsModeUseCase
) {

    suspend fun clearUserData() =  encryptedDataStore.clearUserData()

    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()

    suspend fun isAsModeIsEnabled(isConnectionAvailable: Boolean) = getAsModeUseCase.isAsModeEnabled(isConnectionAvailable)

    suspend fun getEvents(fromLocal: Boolean = false) = getEventsUseCase.getEvents()

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain): EventsListScreenViewState{
        val connectionState = isNetworkAvailable()
        println("нетворкстейт $connectionState")
        val isAsModeEnabled = isAsModeIsEnabled(connectionState).isAsModeActive
        if(isNetworkAvailable()){
                val eventsResult = getEvents()
                return if(eventsResult.errorMsg.isEmpty()){
                    val filtersList = HashSet<String>()
                    eventsResult.events.forEach { event->
                        event.eventSubs.forEach { sub->
                            filtersList.add(sub.subName)
                        }
                    }
                    EventsListScreenViewState.SuccessState(
                        isNetworkAvailable = true,
                        lang = lang,
                        eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                        isAsModeEnabled = isAsModeEnabled,
                        selectedFilters = filtersList.toList()
                    )
                } else{
                    EventsListScreenViewState.ErrorState(error = errorsMsgHandler(eventsResult.errorMsg))
                }
            }
        else{
            val eventsResult = getEvents(fromLocal = true)
            return if(eventsResult.errorMsg.isEmpty()){
                val filtersList = HashSet<String>()
                eventsResult.events.forEach { event->
                    event.eventSubs.forEach { sub->
                        filtersList.add(sub.subName)
                    }
                }
                EventsListScreenViewState.SuccessState(
                    isNetworkAvailable = false,
                    lang = lang,
                    eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                    isAsModeEnabled = isAsModeEnabled,
                    selectedFilters = filtersList.toList()
                    )
            } else{
                EventsListScreenViewState.ErrorState(error = errorsMsgHandler(errorMsg = eventsResult.errorMsg))
            }
        }
    }
}