package ru.kvmsoft.features.events.imp.presentation.ui

import ru.kvmsoft.base.ui.model.AchievementsItemState
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class EventsListScreenViewState {

    data object LoadingState: EventsListScreenViewState()

    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): EventsListScreenViewState()

    data class SuccessState(
        val isNetworkAvailable: Boolean,
        val isAsModeEnabled: Boolean,
        val lang: CurrentLanguageDomain,
        val eventsState: UiState<EventsItemState>,
        val selectedFilters: List<String>
    ): EventsListScreenViewState()
}