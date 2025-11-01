package ru.kvmsoft.features.settings.imp.presentation.ui

sealed class SettingsScreenViewState {

    data object LoadingState: SettingsScreenViewState()

    data class ErrorState(val errorMsg: String): SettingsScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): SettingsScreenViewState()
}