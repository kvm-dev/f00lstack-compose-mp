package ru.kvmsoft.features.tests.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TestResultRequest(
    @SerialName("testId") val testId: Int,
    @SerialName("testResult") val testResult: Int,
    @SerialName("finishTestTime") val finishTestTime: Long
)