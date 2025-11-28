package ru.kvmsoft.features.tests.imp.data.repository

import ru.kvmsoft.features.tests.api.model.request.SendRequestDomain
import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain
import ru.kvmsoft.features.tests.api.model.response.SendResultDomain
import ru.kvmsoft.features.tests.api.model.response.TestsDomain
import ru.kvmsoft.features.tests.imp.data.local.LocalDataSource
import ru.kvmsoft.features.tests.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.tests.imp.mapper.Mapper
import kotlin.time.ExperimentalTime

actual class TestsRepository (
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) {

    actual suspend fun getTestsFromServer(): TestsDomain {
        val result = networkDataSource.getTests()
        return if (result.errorMsg.isEmpty()) {
            localDataSource.saveTests(result)
            localDataSource.getTests()
        } else {
            result
        }
    }

    actual suspend fun getTestsByProfessionFromServer(professionId: Int): TestsDomain {
        val result = networkDataSource.getTestsByProfession(professionId = professionId)
        return if (result.errorMsg.isEmpty()) {
            localDataSource.saveTests(result)
            localDataSource.getTests()
        } else {
            result
        }
    }

    actual suspend fun getTestsFromLocal(): TestsDomain {
        return localDataSource.getTests()
    }

    actual suspend fun getPassedTestsFromServer(): PassedTestsDomain {
        return networkDataSource.getPassedTests()
    }

    actual suspend fun getPassedTestsFromLocal(): PassedTestsDomain {
        return localDataSource.getPassedTests()
    }

    @OptIn(ExperimentalTime::class)
    actual suspend fun sendTestResultToServer(requestDomain: SendRequestDomain): SendResultDomain {
        val currentTime = (kotlin.time.Clock.System.now().toEpochMilliseconds()) / 1000
        return networkDataSource.sendTestResult(Mapper.mapSendResultRequestFromRequestDomain(request = requestDomain, timeStamp = currentTime))
    }

    @OptIn(ExperimentalTime::class)
    actual suspend fun sendTestResultToLocal(requestDomain: SendRequestDomain): SendResultDomain {
        val currentTime = (kotlin.time.Clock.System.now().toEpochMilliseconds()) / 1000
        localDataSource.saveToLocalTestResult(Mapper.mapSendResultRequestFromRequestDomain(requestDomain, timeStamp = currentTime))
        return SendResultDomain(success = true, errorMsg = "")
    }
    actual suspend fun checkOfflineTestsResultDataForIos() {
        val result = localDataSource.getLocalTestResult()
        if(result.isNotEmpty()){
            result.forEach { testResult ->
                networkDataSource.sendTestResult(Mapper.mapToTestResultRequestFromOfflineTestResult(testResult))
            }
            localDataSource.clearLocalTestResult()
        }
    }
}