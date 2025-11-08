package ru.kvmsoft.features.splash.imp.presentation.ui

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain

data class SplashScreenViewState(
    val language: CurrentLanguageDomain,
    val isConnectionAvailable: Boolean,
    val profile: ProfileDomain? = null,
    val userToken: String
)