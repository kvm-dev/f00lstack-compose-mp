package ru.kvmsoft.features.authorization.api.model

data class IsUserExistDomain(
    val success: Boolean,
    val errorMsg: String
)