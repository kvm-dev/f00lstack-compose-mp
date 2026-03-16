package ru.kvmsoft.features.events.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.events.imp.domain.EventsInnerScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenIntents
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenSideEffects
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenViewState

class EventsInnerScreenViewModel(private val interactor: EventsInnerScreenInteractor) : BaseViewModel<EventsInnerScreenViewState, EventsInnerScreenSideEffects>(
    EventsInnerScreenViewState.IdleState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    override fun intentHandler(intent: Any) {
        when(intent){
            is EventsInnerScreenIntents.JoinToEventIntent -> orbitIntent {
                interactor.openEventUrl(intent.url)
            }
            EventsInnerScreenIntents.BackPressedIntent -> orbitIntent {
                postSideEffect(EventsInnerScreenSideEffects.ON_BACK_PRESSED)
            }
            is EventsInnerScreenIntents.InitViewModelIntent -> orbitIntent {
                scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                    val currentState =  interactor.checkState(currentLangState.value, intent.eventId)
                    reduce { currentState }
                }
            }
        }
    }
}
