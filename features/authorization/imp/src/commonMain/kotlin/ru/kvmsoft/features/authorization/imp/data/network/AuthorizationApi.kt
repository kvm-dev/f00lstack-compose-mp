package ru.kvmsoft.features.authorization.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.features.authorization.imp.model.request.AuthByEmailRequest
import ru.kvmsoft.features.authorization.imp.model.request.AuthByTokenOfflineLogRequest
import ru.kvmsoft.features.authorization.imp.model.request.ConfirmAuthAndRegRequest
import ru.kvmsoft.features.authorization.imp.model.request.IsUserExistRequest
import ru.kvmsoft.features.authorization.imp.model.request.RegistrationByEmailRequest
import ru.kvmsoft.features.authorization.imp.model.response.AuthByEmailResponse
import ru.kvmsoft.features.authorization.imp.model.response.AuthByTokenOfflineResponse
import ru.kvmsoft.features.authorization.imp.model.response.AuthByTokenResponse
import ru.kvmsoft.features.authorization.imp.model.response.ConfirmAuthAndRegResponse
import ru.kvmsoft.features.authorization.imp.model.response.IsUserExistResponse
import ru.kvmsoft.features.authorization.imp.model.response.RegistrationByEmailResponse

class AuthorizationApi(private val client: HttpClient) {

    val baseUrl = getBaseUrl()
    suspend fun authByEmail(email: String, code: String): AuthByEmailResponse {
        val result = with(client) {
            post("$baseUrl${AuthorizationEndpoints.authorizationByEmail}"){
                attributes.put(disableAuthKey, true)
                setBody(AuthByEmailRequest(email = email, code = code))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<AuthByEmailResponse>()
        } else{
            AuthByEmailResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun authByToken(): AuthByTokenResponse {
        val defaultResult: AuthByTokenResponse = try {
            val result = with(client) {
                post("$baseUrl${AuthorizationEndpoints.authByToken}")
            }
            if (result.status == HttpStatusCode.OK) {
                result.body<AuthByTokenResponse>()
            } else {
                AuthByTokenResponse(errorMsg = exceptionHandler(result.status).message?: "")
            }
        } catch (e: Throwable){
            AuthByTokenResponse(errorMsg = e.message?: "Unknown error")
        }
        return defaultResult
    }

    suspend fun confirmAuthAndReg(email: String, code: String): ConfirmAuthAndRegResponse {
        val result = with(client) {
            post("$baseUrl${AuthorizationEndpoints.confirmAuthAndReg}"){
                attributes.put(disableAuthKey, true)
                setBody(ConfirmAuthAndRegRequest(email = email, code = code))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<ConfirmAuthAndRegResponse>()
        } else{
            ConfirmAuthAndRegResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun isUserExist(email: String): IsUserExistResponse {
        val result = with(client) {
            post("$baseUrl${AuthorizationEndpoints.isUserExist}"){
                attributes.put(disableAuthKey, true)
                contentType(ContentType.Application.Json)
                setBody(IsUserExistRequest(email = email))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<IsUserExistResponse>()
        } else{
            IsUserExistResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun sendAuthByTokenOfflineLog(request: AuthByTokenOfflineLogRequest): AuthByTokenOfflineResponse {
        val result = with(client) {
            post("$baseUrl${AuthorizationEndpoints.authorizationByTokenOfflineLog}"){
                setBody(request)
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<AuthByTokenOfflineResponse>()
        } else{
            AuthByTokenOfflineResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }

    suspend fun registrationByEmail(email: String): RegistrationByEmailResponse {
        val result = with(client) {
            post("$baseUrl${AuthorizationEndpoints.registrationByEmail}"){
                attributes.put(disableAuthKey, true)
                setBody(RegistrationByEmailRequest(email = email))
            }
        }
        return if(result.status == HttpStatusCode.OK) {
            result.body<RegistrationByEmailResponse>()
        } else{
            RegistrationByEmailResponse(errorMsg = exceptionHandler(result.status).message?: "")
        }
    }
}