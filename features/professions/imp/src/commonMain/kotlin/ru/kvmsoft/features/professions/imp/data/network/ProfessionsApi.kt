package ru.kvmsoft.features.professions.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.professions.imp.model.ProfessionsResponse

class ProfessionsApi(private val client: HttpClient) {
    suspend fun getProfessions(): ProfessionsResponse {
        val result = with(client) {
            attributes.put(disableAuthKey, true)
            get("${getBaseUrl()}${ProfessionsEndpoints.getProfessions}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<ProfessionsResponse>()
        } else{
            ProfessionsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}