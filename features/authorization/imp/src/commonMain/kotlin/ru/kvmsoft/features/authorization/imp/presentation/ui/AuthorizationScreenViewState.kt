package ru.kvmsoft.features.authorization.imp.presentation.ui

import ru.kvmsoft.features.authorization.api.model.AuthorizationErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class AuthorizationScreenViewState {
    data object LoadingState: AuthorizationScreenViewState()
    data class ErrorState(val lang: CurrentLanguageDomain, val error: AuthorizationErrors?): AuthorizationScreenViewState()

    data class AuthorizationRegistrationState(val lang: CurrentLanguageDomain, val error: AuthorizationErrors?): AuthorizationScreenViewState()

    data class OtpState(val lang: CurrentLanguageDomain, val error: AuthorizationErrors?): AuthorizationScreenViewState()
    data object AuthorizedState: AuthorizationScreenViewState()
}