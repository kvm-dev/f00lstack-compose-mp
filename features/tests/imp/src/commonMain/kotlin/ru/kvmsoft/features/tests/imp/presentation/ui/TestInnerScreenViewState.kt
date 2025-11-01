package ru.kvmsoft.features.tests.imp.presentation.ui

sealed class TestInnerScreenViewState {

    data object LoadingState: TestInnerScreenViewState()

    data class ErrorState(val errorMsg: String): TestInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): TestInnerScreenViewState()
}