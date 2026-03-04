package ru.kvmsoft.features.splash.imp.presentation.ui

import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain

sealed class SplashScreenViewState{
   data object Idle : SplashScreenViewState()
    data object Loading : SplashScreenViewState()
}
