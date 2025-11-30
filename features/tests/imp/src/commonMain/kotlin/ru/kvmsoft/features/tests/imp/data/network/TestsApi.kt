package ru.kvmsoft.features.tests.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.tests.imp.model.request.TestResultRequest
import ru.kvmsoft.features.tests.imp.model.response.PassedTestsResponse
import ru.kvmsoft.features.tests.imp.model.response.TestResultResponse
import ru.kvmsoft.features.tests.imp.model.response.TestsResponse

class TestsApi(private val client: HttpClient) {
    suspend fun getTests(): TestsResponse {
        val result = with(client) {
            attributes.put(disableAuthKey, true)
            get("${getBaseUrl()}${TestsEndpoints.getTests}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<TestsResponse>()
        } else{
            TestsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getTestsByProfession(professionId: Int): TestsResponse{
        val result = with(client) {
            attributes.put(disableAuthKey, true)
            get("${getBaseUrl()}${TestsEndpoints.getTestsByProfession}"){
                url {
                    parameters.append("selectedProfession", "$professionId")
                }
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<TestsResponse>()
        } else{
            TestsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getPassedTests(): PassedTestsResponse {
        val result = with(client) {
            get("${getBaseUrl()}${TestsEndpoints.getPassedTests}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<PassedTestsResponse>()
        } else{
            PassedTestsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun sendTestResult(request: TestResultRequest): TestResultResponse {
        val result = with(client) {
            post("${getBaseUrl()}${TestsEndpoints.sendTestResult}"){
                setBody(request)
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<TestResultResponse>()
        } else{
            TestResultResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}