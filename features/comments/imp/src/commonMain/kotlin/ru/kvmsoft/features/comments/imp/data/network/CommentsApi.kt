package ru.kvmsoft.features.comments.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.comments.imp.model.request.MaterialCommentRequest
import ru.kvmsoft.features.comments.imp.model.response.MaterialCommentResponse

class CommentsApi(private val client: HttpClient) {
    suspend fun sendMaterialComment(request: MaterialCommentRequest): MaterialCommentResponse {
        val result = with(client) {
            post("${getBaseUrl()}${CommentsEndpoints.commentMaterial}"){
                setBody(request)
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<MaterialCommentResponse>()
        } else{
            MaterialCommentResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}