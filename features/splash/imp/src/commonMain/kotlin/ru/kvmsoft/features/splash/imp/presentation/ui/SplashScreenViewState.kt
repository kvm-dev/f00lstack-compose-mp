package ru.kvmsoft.features.splash.imp.presentation.ui

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class SplashScreenViewState {

    data object LoadingState: SplashScreenViewState()

    data class ErrorState(val errorMsg: String): SplashScreenViewState()

    data class SuccessState(
        val language: CurrentLanguageDomain
    ): SplashScreenViewState()
}