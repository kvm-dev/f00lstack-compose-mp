package ru.kvmsoft.features.interview.imp.presentation.ui

sealed class InterviewInnerScreenViewState {

    data object LoadingState: InterviewInnerScreenViewState()

    data class ErrorState(val errorMsg: String): InterviewInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): InterviewInnerScreenViewState()
}