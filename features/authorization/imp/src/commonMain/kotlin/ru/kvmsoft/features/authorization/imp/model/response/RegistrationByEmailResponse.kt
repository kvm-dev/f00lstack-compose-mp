package ru.kvmsoft.features.authorization.imp.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationByEmailResponse(
    @SerialName("success") val success: Boolean = false,
    @SerialName("errorMsg") val errorMsg: String
)