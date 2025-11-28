package ru.kvmsoft.features.tests.api.model.response

data class PassedTestsDomain(
    val success: Boolean,
    val passedTests: List<PassedTestDomain>,
    val errorMsg: String
)

data class PassedTestDomain(
    val testId: Int,
    val testResult: Int,
    val finishTestTime: Long
)