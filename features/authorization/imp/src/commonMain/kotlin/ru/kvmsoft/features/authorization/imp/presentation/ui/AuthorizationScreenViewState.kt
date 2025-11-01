package ru.kvmsoft.features.authorization.imp.presentation.ui

sealed class AuthorizationScreenViewState {

    data object LoadingState: AuthorizationScreenViewState()

    data class ErrorState(val errorMsg: String): AuthorizationScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): AuthorizationScreenViewState()
}