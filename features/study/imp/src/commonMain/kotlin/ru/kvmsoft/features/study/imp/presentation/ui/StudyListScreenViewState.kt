package ru.kvmsoft.features.study.imp.presentation.ui

import ru.kvmsoft.base.ui.model.StudiesItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class StudyListScreenViewState {

    data object LoadingState: StudyListScreenViewState()

    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): StudyListScreenViewState()

    data class SuccessState(
        val studiesState: UiState<StudiesItemState>,
        val isNetworkAvailable: Boolean,
        val isAsModeEnabled: Boolean,
        val lang: CurrentLanguageDomain,
        val selectedFilters: List<String>
    ): StudyListScreenViewState()
}