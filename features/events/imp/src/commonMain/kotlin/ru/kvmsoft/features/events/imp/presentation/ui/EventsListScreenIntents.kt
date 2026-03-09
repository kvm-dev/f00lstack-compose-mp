package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.navigation.NavController

sealed class EventsListScreenIntents {
    data object InitViewModelIntent : EventsListScreenIntents()

    data class UpdateFiltersIntent(val subName: String): EventsListScreenIntents()
    data object NavigateToEventDetailsIntent: EventsListScreenIntents()
}