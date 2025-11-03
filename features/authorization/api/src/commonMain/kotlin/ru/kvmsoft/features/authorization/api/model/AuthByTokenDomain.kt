package ru.kvmsoft.features.authorization.api.model

data class AuthByTokenDomain(
    val success: Boolean,
    val errorMsg: String
)