package ru.kvmsoft.features.profile.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.profile.imp.model.request.UpdateEmailRequest
import ru.kvmsoft.features.profile.imp.model.request.UpdateNameRequest
import ru.kvmsoft.features.profile.imp.model.response.DeleteProfileResponse
import ru.kvmsoft.features.profile.imp.model.response.ProfileResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdateEmailResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdateNameResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdatePhotoResponse

class ProfileApi(private val client: HttpClient) {
    suspend fun getProfile(): ProfileResponse {
        val result = with(client) {
            get("${getBaseUrl()}${ProfileEndpoints.getProfile}")
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<ProfileResponse>()
        } else{
            ProfileResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun updateEmail(email: String): UpdateEmailResponse {
        val result = with(client) {
            post("${getBaseUrl()}${ProfileEndpoints.updateEmail}"){
                setBody(UpdateEmailRequest(email = email))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<UpdateEmailResponse>()
        } else{
            UpdateEmailResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun updateName(name: String): UpdateNameResponse {
        val result = with(client) {
            post("${getBaseUrl()}${ProfileEndpoints.updateName}"){
                setBody(UpdateNameRequest(name = name))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<UpdateNameResponse>()
        } else{
            UpdateNameResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun updatePhoto(photo: ByteArray
    ): UpdatePhotoResponse {
        val result = with(client) {
            post("${getBaseUrl()}${ProfileEndpoints.updatePhoto}"){
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append("profileFile", photo, Headers.build {
                                append(HttpHeaders.ContentType, "image/*")
                                append(HttpHeaders.ContentDisposition, "filename=profileFile.png")
                            })
                        }
                    )
                )
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<UpdatePhotoResponse>()
        } else{
            UpdatePhotoResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun deleteProfile(): DeleteProfileResponse {
        val result = with(client) {
            post("${getBaseUrl()}${ProfileEndpoints.deleteProfile}"){
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<DeleteProfileResponse>()
        } else{
            DeleteProfileResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}