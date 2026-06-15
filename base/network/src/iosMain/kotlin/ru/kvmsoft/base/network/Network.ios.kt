package ru.kvmsoft.base.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.first
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.localeIdentifier
import ru.kvmsoft.base.network.endpoints.RefreshEndpoints
import ru.kvmsoft.base.network.model.NetworkError
import ru.kvmsoft.base.network.model.PlatformType
import ru.kvmsoft.base.network.model.UserType
import ru.kvmsoft.base.network.model.request.RefreshTokenRequest
import ru.kvmsoft.base.network.model.response.RefreshTokenResponse
import ru.kvmsoft.base.network.utils.disableAuthPlugin
import ru.kvmsoft.base.network.utils.getBaseUrl
import ru.kvmsoft.base.network.utils.getCurrentVersion
import ru.kvmsoft.base.network.utils.getPlatform
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore

actual object HttpClientProvider {

    // 1. Изолированный клиент для iOS без плагина Auth (предотвращает дедлок)
    private val refreshClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15_000
            connectTimeoutMillis = 10_000
        }
        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    actual val client: HttpClient by lazy {
        val encryptedDataStore = EncryptedDataStore()

        HttpClient(Darwin) {
            install(HttpTimeout) {
                requestTimeoutMillis = 30_000
                connectTimeoutMillis = 15_000
                socketTimeoutMillis = 30_000
            }

            install(ResponseObserver) {
                onResponse { response ->
                    println("HTTP status: ${response.status.value}")
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("KtorClient: $message")
                    }
                }
                level = LogLevel.ALL
            }

            install(Auth) {
                bearer {
                    // Вызывается перед каждым запросом. Позволяет обновлять токен на лету
                    loadTokens {
                        val accessToken = encryptedDataStore.accessToken.first()
                        val refreshToken = encryptedDataStore.refreshToken.first()

                        if (accessToken.isNotEmpty() && refreshToken.isNotEmpty()) {
                            BearerTokens(accessToken, refreshToken)
                        } else {
                            null
                        }
                    }

                    // Обязательно: отправляем заголовок превентивно
                    sendWithoutRequest { request ->
                        !request.url.encodedPath.contains(RefreshEndpoints.refreshToken)
                    }

                    // Вызывается при ошибке 401 Unauthorized
                    refreshTokens {
                        val currentAccessToken = encryptedDataStore.accessToken.first()
                        val currentRefreshToken = encryptedDataStore.refreshToken.first()

                        try {
                            // 2. Используем чистый refreshClient вместо основного client
                            val result = refreshClient.post("${getBaseUrl()}${RefreshEndpoints.refreshToken}") {
                                contentType(ContentType.Application.Json)
                                setBody(RefreshTokenRequest(refreshToken = currentRefreshToken))
                                header(HttpHeaders.Authorization, "Bearer $currentAccessToken")
                            }

                            if (result.status == HttpStatusCode.OK) {
                                val tokensResponse = result.body<RefreshTokenResponse>()

                                // Сохраняем новые данные
                                encryptedDataStore.saveToken(tokensResponse.userToken)
                                encryptedDataStore.saveRefreshToken(tokensResponse.userRefreshToken)

                                BearerTokens(tokensResponse.userToken, tokensResponse.userRefreshToken)
                            } else {
                                encryptedDataStore.clearUserData()
                                throw NetworkError.Unauthorized()
                            }
                        } catch (e: Exception) {
                            encryptedDataStore.clearUserData()
                            throw NetworkError.Unauthorized()
                        }
                    }
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("Local", if (NSLocale.currentLocale.localeIdentifier.lowercase().contains("ru")) { "RU" } else { "ENG" })
                header("Platform", if(getPlatform() == PlatformType.ANDROID) "android" else "ios")
                header("Version", getCurrentVersion())
                header(UserType.Client().key, UserType.Client().type)
            }

            install(disableAuthPlugin())

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }

            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
    }
}