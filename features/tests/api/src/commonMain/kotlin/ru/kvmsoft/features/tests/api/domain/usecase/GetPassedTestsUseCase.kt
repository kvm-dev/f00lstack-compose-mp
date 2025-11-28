package ru.kvmsoft.features.tests.api.domain.usecase

import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain

interface GetPassedTestsUseCase {

    suspend fun getPassedTests(fromLocal: Boolean = false): PassedTestsDomain

}