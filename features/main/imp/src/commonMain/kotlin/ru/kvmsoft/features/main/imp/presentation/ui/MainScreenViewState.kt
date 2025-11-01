package ru.kvmsoft.features.main.imp.presentation.ui

sealed class MainScreenViewState {

    data object LoadingState: MainScreenViewState()

    data class ErrorState(val errorMsg: String): MainScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): MainScreenViewState()
}