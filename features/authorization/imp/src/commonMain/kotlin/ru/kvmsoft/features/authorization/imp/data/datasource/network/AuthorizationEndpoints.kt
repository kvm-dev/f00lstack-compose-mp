package ru.kvmsoft.features.authorization.imp.data.datasource.network

object AuthorizationEndpoints {
    val isUserExist: String
        get() = "auth/is-user-exist/"

    val authByToken: String
        get() = "auth/token/"

    val refreshToken: String
        get() = "auth/refresh-token/"

    val confirmAuthAndReg: String
        get() = "confirm-auth-reg/confirm-email/"

    val authorizationByEmail: String
        get() = "auth/email/"

    val authorizationByTokenOfflineLog: String
        get() = "auth/token-offline/"

    val registrationByEmail: String
        get() = "reg/email/"
}