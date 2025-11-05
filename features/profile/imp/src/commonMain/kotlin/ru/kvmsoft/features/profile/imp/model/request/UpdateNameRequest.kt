package ru.kvmsoft.features.profile.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateNameRequest(
    @SerialName("name") val name: String
)