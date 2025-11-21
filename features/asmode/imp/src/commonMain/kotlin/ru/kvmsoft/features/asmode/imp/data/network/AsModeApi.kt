package ru.kvmsoft.features.asmode.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.asmode.imp.model.AsModeResponse

class AsModeApi(private val client: HttpClient) {
    suspend fun getAsMode(): AsModeResponse {
        val result = with(client) {
            get("${getBaseUrl()}${AsModeEndpoints.getAsMode}"){
                attributes.put(disableAuthKey, true)
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<AsModeResponse>()
        } else{
            AsModeResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}