package ru.kvmsoft.features.authorization.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IsUserExistRequest(
    @SerialName("email") val email: String
)