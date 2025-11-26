package ru.kvmsoft.features.news.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.news.imp.model.NewsResponse
import ru.kvmsoft.features.news.imp.model.NewsVersionResponse

class NewsApi(private val client: HttpClient) {
    suspend fun getNews(): NewsResponse {
        val result = with(client) {
            get("${getBaseUrl()}${NewsEndpoints.getNews}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<NewsResponse>()
        } else{
            NewsResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getVersion(): NewsVersionResponse{
        val result = with(client) {
            get("${getBaseUrl()}${NewsEndpoints.getNewsVersion}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<NewsVersionResponse>()
        } else{
            NewsVersionResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}