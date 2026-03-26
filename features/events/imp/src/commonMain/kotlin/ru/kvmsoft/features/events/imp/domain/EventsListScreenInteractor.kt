package ru.kvmsoft.features.events.imp.domain

import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.imp.mapper.Mapper.mapToEventsItems
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenViewState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class EventsListScreenInteractor(
    private val getEventsUseCase: GetEventsUseCase,
    getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val getAsModeUseCase: GetAsModeUseCase,
    private val browserUtils: BrowserUtils
) {

    val langState = getCurrentLanguageUseCase.langState

    suspend fun isAsModeIsEnabled(isConnectionAvailable: Boolean) = getAsModeUseCase.isAsModeEnabled(isConnectionAvailable)

    private suspend fun getEvents(fromLocal: Boolean = false) = getEventsUseCase.getEvents(fromLocal)

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain): EventsListScreenViewState{
        val connectionState = isNetworkAvailable()
        val isAsModeEnabled = isAsModeIsEnabled(connectionState).isAsModeActive
        if(isNetworkAvailable()){
                val eventsResult = getEvents()
                    val filtersList = HashSet<String>()
                    eventsResult.events.forEach { event->
                        event.eventSubs.forEach { sub->
                            filtersList.add(sub.subName)
                        }
                    }
                   return EventsListScreenViewState.SuccessState(
                        isNetworkAvailable = true,
                        lang = lang,
                        eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                        isAsModeEnabled = isAsModeEnabled,
                        selectedFilters = filtersList.toList()
                    )
            }
        else{
            val eventsResult = getEvents(fromLocal = true)
                val filtersList = HashSet<String>()
                eventsResult.events.forEach { event->
                    event.eventSubs.forEach { sub->
                        filtersList.add(sub.subName)
                    }
                }
               return EventsListScreenViewState.SuccessState(
                    isNetworkAvailable = false,
                    lang = lang,
                    eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                    isAsModeEnabled = isAsModeEnabled,
                    selectedFilters = filtersList.toList()
                    )
        }
    }

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }
}