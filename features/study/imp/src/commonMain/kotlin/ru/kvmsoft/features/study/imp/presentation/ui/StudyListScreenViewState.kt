package ru.kvmsoft.features.study.imp.presentation.ui

sealed class StudyListScreenViewState {

    data object LoadingState: StudyListScreenViewState()

    data class ErrorState(val errorMsg: String): StudyListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): StudyListScreenViewState()
}