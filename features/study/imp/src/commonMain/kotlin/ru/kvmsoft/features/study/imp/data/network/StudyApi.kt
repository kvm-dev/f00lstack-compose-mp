package ru.kvmsoft.features.study.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.study.imp.model.StudiesResponse
import ru.kvmsoft.features.study.imp.model.StudiesVersionResponse

class StudyApi(private val client: HttpClient) {
    suspend fun getStudies(): StudiesResponse {
        val result = with(client) {
            attributes.put(disableAuthKey, true)
            get("${getBaseUrl()}${StudyEndpoints.getStudies}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<StudiesResponse>()
        } else{
            StudiesResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getVersion(): StudiesVersionResponse {
        val result = with(client) {
            attributes.put(disableAuthKey, true)
            get("${getBaseUrl()}${StudyEndpoints.getStudiesVersion}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<StudiesVersionResponse>()
        } else{
            StudiesVersionResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}