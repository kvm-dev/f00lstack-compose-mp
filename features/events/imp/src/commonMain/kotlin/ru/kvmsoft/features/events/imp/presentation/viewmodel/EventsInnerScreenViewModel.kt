package ru.kvmsoft.features.events.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.events.imp.domain.EventsInnerScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenIntents
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenSideEffects
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class EventsInnerScreenViewModel(private val interactor: EventsInnerScreenInteractor) : BaseViewModel<EventsInnerScreenViewState, EventsInnerScreenSideEffects>(
    EventsInnerScreenViewState.IdleState
) {
    fun openChat() = {
        interactor.openChat()
    }

    fun joinToEvent(url: String) {
        interactor.openEventUrl(url = url)
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            is EventsInnerScreenIntents.JoinToEventIntent -> orbitIntent {
                postSideEffect(EventsInnerScreenSideEffects.JoinToEvent(intent.url))
            }
            EventsInnerScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(EventsInnerScreenSideEffects.OpenChat)
            }
            EventsInnerScreenIntents.BackPressedIntent -> orbitIntent {
                postSideEffect(EventsInnerScreenSideEffects.OnBackPressed)
            }
            EventsInnerScreenIntents.CloseApplication -> orbitIntent {
                postSideEffect(EventsInnerScreenSideEffects.CloseApp)
            }

            is EventsInnerScreenIntents.InitViewModelIntent -> orbitIntent {
                    val currentState = interactor.checkState(lang = getLang(), eventId = intent.eventId)
                    reduce { currentState }
            }
        }
    }
}
