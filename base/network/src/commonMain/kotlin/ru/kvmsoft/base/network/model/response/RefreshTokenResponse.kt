package ru.kvmsoft.base.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenResponse(
    @SerialName("success") val success: Boolean = false,
    @SerialName("userToken") val userToken: String = "",
    @SerialName("userRefreshToken") val userRefreshToken: String = "",
    @SerialName("errorMsg") val errorMsg: String
)