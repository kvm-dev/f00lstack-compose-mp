package ru.kvmsoft.features.interview.imp.presentation.ui

sealed class InterviewListScreenViewState {

    data object LoadingState: InterviewListScreenViewState()

    data class ErrorState(val errorMsg: String): InterviewListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): InterviewListScreenViewState()
}