package ru.kvmsoft.features.events.imp.presentation.ui

sealed class EventsInnerScreenSideEffects {
    data object OnBackPressed: EventsInnerScreenSideEffects()
    data object OpenChat: EventsInnerScreenSideEffects()
    data object CloseApp: EventsInnerScreenSideEffects()
    data class JoinToEvent(val url: String): EventsInnerScreenSideEffects()
}