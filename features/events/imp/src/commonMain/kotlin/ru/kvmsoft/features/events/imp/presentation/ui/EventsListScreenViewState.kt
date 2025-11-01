package ru.kvmsoft.features.events.imp.presentation.ui

sealed class EventsListScreenViewState {

    data object LoadingState: EventsListScreenViewState()

    data class ErrorState(val errorMsg: String): EventsListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): EventsListScreenViewState()
}