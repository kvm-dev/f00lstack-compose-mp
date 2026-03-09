package ru.kvmsoft.features.tests.imp.presentation.ui

sealed class TestsInnerScreenViewState {

    data object LoadingState: TestsInnerScreenViewState()

    data class ErrorState(val errorMsg: String): TestsInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): TestsInnerScreenViewState()
}