package ru.kvmsoft.features.profile.imp.presentation.ui

sealed class ProfileScreenViewState {

    data object LoadingState: ProfileScreenViewState()

    data class ErrorState(val errorMsg: String): ProfileScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): ProfileScreenViewState()
}