package ru.kvmsoft.features.events.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.events.imp.model.EventsResponse
import ru.kvmsoft.features.events.imp.model.EventsVersionResponse

class EventsApi(private val client: HttpClient) {
    suspend fun getEvents(): EventsResponse {
        val result = with(client) {
            get("${getBaseUrl()}${EventsEndpoints.getEvents}"){
                attributes.put(disableAuthKey, true)
            }
        }
        return if (result.status == HttpStatusCode.OK) {
            result.body<EventsResponse>()
        } else {
            EventsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getVersion(): EventsVersionResponse {
        val result = with(client) {
            get("${getBaseUrl()}${EventsEndpoints.getEventsVersion}"){
                attributes.put(disableAuthKey, true)
            }
        }
        return if (result.status == HttpStatusCode.OK) {
            result.body<EventsVersionResponse>()
        } else {
            EventsVersionResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

}