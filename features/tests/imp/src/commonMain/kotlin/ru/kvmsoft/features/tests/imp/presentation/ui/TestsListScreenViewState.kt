package ru.kvmsoft.features.tests.imp.presentation.ui

sealed class TestsListScreenViewState {

    data object LoadingState: TestsListScreenViewState()

    data class ErrorState(val errorMsg: String): TestsListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): TestsListScreenViewState()
}