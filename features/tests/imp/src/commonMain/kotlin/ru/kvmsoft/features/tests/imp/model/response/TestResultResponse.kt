package ru.kvmsoft.features.tests.imp.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TestResultResponse(
    @SerialName("success") val success: Boolean = false,
    @SerialName("errorMsg") val errorMsg: String = ""
)