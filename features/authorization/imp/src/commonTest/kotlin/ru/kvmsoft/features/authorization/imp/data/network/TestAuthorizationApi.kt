package ru.kvmsoft.features.authorization.imp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import ru.kvmsoft.base.network.model.PlatformType
import ru.kvmsoft.base.network.model.UserType
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.base.network.utils.exceptionHandler
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.base.network.utils.getCurrentVersion
import ru.kvmsoft.base.network.utils.getPlatform
import ru.kvmsoft.features.authorization.imp.model.request.AuthByEmailRequest
import ru.kvmsoft.features.authorization.imp.model.response.AuthByEmailResponse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestAuthorizationApi() {
    @Test
    fun `authByEmail returns AuthByEmailResponse`() = runTest {
        val correctResponse = AuthByEmailResponse(userToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJyZWREYXRlIjoxNzQxNzI2ODI2LCJsb2dpbiI6InRlc3RAZm9vbHN0YWNrLnJ1IiwidG9rZW5FeHAiOjE3NDk0MTY0MjYsInVzZXJfdG9rZW5fbGFzdF91cGRhdGUiOjE3NDE3MjY4MjYsInVzZXJJZCI6MX0.LWXXjwJmCjzH5SVAHTBjTqCvMB1f1IEa20JTQSZZkH-GRoQ-qBIJ4boPOLlbjLiuy-IPd7ya_wc49mhI2IVghn6Bz3qMMeHF4mRAzHNgEZyRVRJcWD6KEzlrp1Fe063DDqpkRixyeY6UsgJgwgEklWYBo-uD-XFBt27Cbvr5V60", userRefreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJyZWZyZXNoX3Rva2VuX2xhc3RfdXBkYXRlIjoxNzQxNzI2ODI2fQ.UWK_ziCO7BMoUiu43VKiT2K7cD1_zgrDVKh9yIqWGnKjw2m8105HbdrPIpNKMu9osaKcqO4s6pAEFA-iu5AichwQZPC3N-29-kw45UqQ__jSHIHertCV-FsGRdqaUnYb6sPqeAzENblYAAp6BOSozsDf9f1B-6QOqE5sExxhkv0", "")
        // runTest автоматически пропускает delay()
                val result = with(HttpClient(NetworkMocks.authByEmailCorrectMock){
                                install(ContentNegotiation) {
                register(
                    ContentType.Application.Json, KotlinxSerializationConverter(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                            explicitNulls = false
                        }
                    )
                )
            }
                    install(DefaultRequest) {
                        header(HttpHeaders.ContentType, ContentType.Application.Json)
                        header("Local", "RU")
                        header("Platform", if(getPlatform() == PlatformType.ANDROID) "android" else "ios")
                        header("Version", getCurrentVersion())
                        header(UserType.Client().key, UserType.Client().type)
                    }
                }) {
                post("${getBaseUrl()}${AuthorizationEndpoints.authorizationByEmail}"){
                attributes.put(disableAuthKey, true)
                setBody(AuthByEmailRequest(email = "example@example.com", code = "1111"))
            }
        }
        if(result.status == HttpStatusCode.OK){
            val response =  result.body<AuthByEmailResponse>()
            assertEquals(correctResponse, response, "ответ успешный")
            assertTrue(response is AuthByEmailResponse)

        }
        else{
            val response = AuthByEmailResponse(errorMsg = exceptionHandler(result.status).message?: "")
            assertEquals(correctResponse, response, "ответ неуспешный")

        }
    }
}