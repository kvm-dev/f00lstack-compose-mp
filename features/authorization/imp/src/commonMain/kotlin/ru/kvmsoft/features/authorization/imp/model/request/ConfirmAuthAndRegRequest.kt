package ru.kvmsoft.features.authorization.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfirmAuthAndRegRequest(
   @SerialName("email") val email: String,
   @SerialName("code") val code: String
)