package ru.kvmsoft.base.network.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    @SerialName("refreshToken") val refreshToken: String
)