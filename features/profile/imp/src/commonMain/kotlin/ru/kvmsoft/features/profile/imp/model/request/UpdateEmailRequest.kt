package ru.kvmsoft.features.profile.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateEmailRequest(
    @SerialName("email") val email: String
)