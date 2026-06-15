package ru.kvmsoft.features.events.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.events.imp.domain.EventsListScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenIntents
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenSideEffects
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class EventsListScreenViewModel(private val interactor: EventsListScreenInteractor) : BaseViewModel<EventsListScreenViewState, EventsListScreenSideEffects>(
    EventsListScreenViewState.LoadingState
) {
    fun initViewModel() = orbitIntent {
            reduce { EventsListScreenViewState.LoadingState }
                    val currentState = interactor.checkState(lang = getLang())
                    reduce { currentState }
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    fun openChat() {
        interactor.openChat()
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            EventsListScreenIntents.InitViewModelIntent -> initViewModel()
            is EventsListScreenIntents.UpdateFiltersIntent -> orbitIntent {
                if(intent.subName.isNotEmpty()){
                    val current = state as EventsListScreenViewState.SuccessState
                    val selectedFilters = HashSet<String>()
                    current.selectedFilters.forEach { sub->
                        selectedFilters.add(sub)
                    }
                    if(selectedFilters.contains(intent.subName)){
                        selectedFilters.remove(intent.subName)
                    }
                    else{
                        selectedFilters.add(intent.subName)
                    }
                    reduce { current.copy(selectedFilters = selectedFilters.toList()) }
                }
            }

            is EventsListScreenIntents.NavigateToEventDetailsIntent -> orbitIntent {
                postSideEffect(EventsListScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN)
            }
            EventsListScreenIntents.OpenChatIntent -> orbitIntent { postSideEffect(EventsListScreenSideEffects.OPEN_CHAT) }

            EventsListScreenIntents.RefreshIntent ->  orbitIntent {
                postSideEffect(EventsListScreenSideEffects.REFRESH_SCREEN)
            }
            EventsListScreenIntents.OnClickBack ->  orbitIntent {
                postSideEffect(EventsListScreenSideEffects.ON_CLICK_BACK)
            }
            EventsListScreenIntents.CloseApplication ->  orbitIntent {
                postSideEffect(EventsListScreenSideEffects.CLOSE_APP)
            }
        }
    }
}