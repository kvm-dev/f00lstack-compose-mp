package ru.kvmsoft.features.books.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.books.imp.model.BooksResponse
import ru.kvmsoft.features.books.imp.model.BooksVersionResponse

class BooksApi(private val client: HttpClient) {
    suspend fun getBooks(): BooksResponse {
        val result = with(client) {
            get("${getBaseUrl()}${BooksEndpoints.getBooks}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<BooksResponse>()
        } else{
            BooksResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun getVersion(): BooksVersionResponse{
        val result = with(client) {
            get("${getBaseUrl()}${BooksEndpoints.getBooksVersion}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<BooksVersionResponse>()
        } else{
            BooksVersionResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}