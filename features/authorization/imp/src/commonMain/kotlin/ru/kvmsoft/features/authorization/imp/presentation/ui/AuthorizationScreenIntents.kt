package ru.kvmsoft.features.authorization.imp.presentation.ui

sealed class AuthorizationScreenIntents {
    data object InitViewModelIntent : AuthorizationScreenIntents()
    data object RestartUiIntent : AuthorizationScreenIntents()
    data object OpenChatIntent : AuthorizationScreenIntents()
    data object GoToAuthorizationIntent : AuthorizationScreenIntents()
    data class SetEmailIntent(val value: String)
    data class SetOtpIntent(val value: String)
    data class SetEmailErrorIntent(val value: String)
    data class SetOtpErrorIntent(val value: String)
}