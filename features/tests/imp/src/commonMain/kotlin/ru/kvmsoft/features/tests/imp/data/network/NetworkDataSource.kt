package ru.kvmsoft.features.tests.imp.data.network

import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain
import ru.kvmsoft.features.tests.api.model.response.TestsDomain
import ru.kvmsoft.features.tests.imp.mapper.Mapper
import ru.kvmsoft.features.tests.imp.model.request.TestResultRequest

class NetworkDataSource(private val api: TestsApi){

    suspend fun getTests(): TestsDomain = Mapper.mapTestsDomainFromResponse(api.getTests())

    suspend fun getTestsByProfession(professionId: Int): TestsDomain  = Mapper.mapTestsDomainFromResponse(api.getTestsByProfession(professionId = professionId))

    suspend fun getPassedTests(): PassedTestsDomain = Mapper.mapPassedTestsDomainFromResponse(api.getPassedTests())

    suspend fun sendTestResult(request: TestResultRequest) = Mapper.mapTestResultDomainFromTestResultResponse(api.sendTestResult(request = request))
}