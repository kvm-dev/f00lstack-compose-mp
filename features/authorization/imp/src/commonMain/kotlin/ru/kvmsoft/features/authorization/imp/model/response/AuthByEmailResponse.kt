package ru.kvmsoft.features.authorization.imp.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthByEmailResponse(
    @SerialName("userToken") val userToken: String = "",
    @SerialName("userRefreshToken") val userRefreshToken: String = "",
    @SerialName("errorMsg") val errorMsg: String
)