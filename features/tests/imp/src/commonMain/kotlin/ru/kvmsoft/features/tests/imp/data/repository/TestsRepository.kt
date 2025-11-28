package ru.kvmsoft.features.tests.imp.data.repository

import ru.kvmsoft.features.tests.api.model.request.SendRequestDomain
import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain
import ru.kvmsoft.features.tests.api.model.response.SendResultDomain
import ru.kvmsoft.features.tests.api.model.response.TestsDomain


expect class TestsRepository{

    suspend fun checkOfflineTestsResultDataForIos()

    suspend fun getTestsFromServer(): TestsDomain

    suspend fun getTestsByProfessionFromServer(professionId: Int): TestsDomain

    suspend fun getTestsFromLocal(): TestsDomain

    suspend fun getPassedTestsFromServer(): PassedTestsDomain

    suspend fun getPassedTestsFromLocal(): PassedTestsDomain

    suspend fun sendTestResultToServer(requestDomain: SendRequestDomain): SendResultDomain

    suspend fun sendTestResultToLocal(requestDomain: SendRequestDomain): SendResultDomain
}