package ru.kvmsoft.features.events.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.events.imp.domain.EventsInnerScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenSideEffects
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenViewState

class EventsInnerScreenViewModel(private val interactor: EventsInnerScreenInteractor) : BaseViewModel<EventsInnerScreenViewState, EventsInnerScreenSideEffects>(
    EventsInnerScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}
