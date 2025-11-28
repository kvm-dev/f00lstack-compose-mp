package ru.kvmsoft.features.tests.api.domain.usecase

import ru.kvmsoft.features.tests.api.model.response.TestsDomain

interface GetTestsUseCase {

    suspend fun getTests(fromLocal: Boolean = false): TestsDomain

    suspend fun getTestsByProfession(professionId: Int, fromLocal: Boolean = false): TestsDomain

}