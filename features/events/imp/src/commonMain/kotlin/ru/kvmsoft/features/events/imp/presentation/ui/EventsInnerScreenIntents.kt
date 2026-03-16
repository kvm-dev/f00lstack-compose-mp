package ru.kvmsoft.features.events.imp.presentation.ui

sealed class EventsInnerScreenIntents {
    data class InitViewModelIntent(val eventId: Int) : EventsInnerScreenIntents()
    data object BackPressedIntent : EventsInnerScreenIntents()
    data class JoinToEventIntent(val url: String) : EventsInnerScreenIntents()
}