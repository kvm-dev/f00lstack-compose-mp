package ru.kvmsoft.features.events.imp.presentation.ui

sealed class EventsListScreenIntents {
    data object InitViewModelIntent : EventsListScreenIntents()
    data object OpenChatIntent: EventsListScreenIntents()

    data class UpdateFiltersIntent(val subName: String): EventsListScreenIntents()
    data object NavigateToEventDetailsIntent: EventsListScreenIntents()
}