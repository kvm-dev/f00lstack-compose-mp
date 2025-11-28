package ru.kvmsoft.features.tests.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.base.storage.model.OfflineTestResult
import ru.kvmsoft.features.tests.api.model.response.PassedTestDomain
import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain
import ru.kvmsoft.features.tests.api.model.response.TestsDomain
import ru.kvmsoft.features.tests.imp.mapper.Mapper
import ru.kvmsoft.features.tests.imp.model.request.TestResultRequest

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getTests(): TestsDomain {
        return Mapper.mapTestsDomain(databaseSdk.getTests())
    }

    suspend fun getPassedTests(): PassedTestsDomain {
        return Mapper.mapPassedTestsDomainFromLocal(databaseSdk.getPassedTests())
    }

    suspend fun savePassedTests(passedTests: PassedTestsDomain){
        databaseSdk.savePassedTests(passedTests = Mapper.mapPassedTestsDomainToPassedTests(passedTests))
    }

    suspend fun savePassedTest(passedTest: PassedTestDomain){
        databaseSdk.savePassedTest(passedTest = Mapper.mapPassedTestDomainToPassedTest(passedTest))
    }

    suspend fun saveTests(tests: TestsDomain){
        databaseSdk.saveTests(tests = Mapper.map(tests))
    }

    suspend fun getLocalTestResult(): List<OfflineTestResult>{
        return databaseSdk.getOfflineTestResults()
    }

    suspend fun saveToLocalTestResult(testResultRequest: TestResultRequest){
        databaseSdk.saveOfflineTestResult(Mapper.mapTestResultToLocalTestResult(testResultRequest))
    }

    suspend fun clearLocalTestResult(){
        databaseSdk.clearOfflineTestResults()
    }
}