package ru.kvmsoft.features.events.imp.presentation.ui

sealed class EventsInnerScreenViewState {

    data object LoadingState: EventsInnerScreenViewState()

    data class ErrorState(val errorMsg: String): EventsInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): EventsInnerScreenViewState()
}