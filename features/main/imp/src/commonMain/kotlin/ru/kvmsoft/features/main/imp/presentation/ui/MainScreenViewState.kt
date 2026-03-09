package ru.kvmsoft.features.main.imp.presentation.ui

import ru.kvmsoft.base.ui.model.AchievementsItemState
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.base.utils.model.BaseErrors

sealed class MainScreenViewState {

    data object LoadingState: MainScreenViewState()
    data class ErrorState(val error: BaseErrors): MainScreenViewState()

    data class SuccessState(
        val isNetworkAvailable: Boolean,
        val isAsModeEnabled: Boolean,
        val lang: CurrentLanguageDomain,
        val userName: String,
        val achievements: UiState<AchievementsItemState>,
        val eventsState: UiState<EventsItemState>,
        val isKnowHowToUseSlider: Boolean
    ): MainScreenViewState()
}