package ru.kvmsoft.base.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
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
import org.koin.java.KoinJavaComponent.inject
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
import java.util.Locale

actual object HttpClientProvider {

    // 1. Создаем изолированный клиент ТОЛЬКО для запроса обновления токенов (без плагина Auth!)
    private val refreshClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15_000
            connectTimeoutMillis = 10_000
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    actual val client: HttpClient by lazy {
        val encryptedDataStore: EncryptedDataStore by inject(EncryptedDataStore::class.java)

        HttpClient(OkHttp) {
            install(HttpTimeout) {
                requestTimeoutMillis = 30_000
                connectTimeoutMillis = 15_000
                socketTimeoutMillis = 30_000
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("KtorClient", message)
                    }
                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP status:", "${response.status.value}")
                }
            }

            install(Auth) {
                bearer {
                    // loadTokens срабатывает при КАЖДОМ новом запросе к API.
                    // Так как DataStore отдает актуальные данные через .first(),
                    // новые токены подтянутся в реальном времени сразу после сохранения.
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

                    // Срабатывает только если сервер вернул 401 Unauthorized
                    refreshTokens {
                        // Важно брать токены заново, так как они могли обновиться в другом параллельном запросе
                        val currentAccessToken = encryptedDataStore.accessToken.first()
                        val currentRefreshToken = encryptedDataStore.refreshToken.first()

                        try {
                            // 2. Используем чистый refreshClient вместо основного client, чтобы избежать дедлока
                            val result = refreshClient.post("${getBaseUrl()}${RefreshEndpoints.refreshToken}") {
                                contentType(ContentType.Application.Json)
                                setBody(RefreshTokenRequest(refreshToken = currentRefreshToken))
                                // Передаем старый accessToken в заголовок, если этого требует ваш бэкенд
                                header(HttpHeaders.Authorization, "Bearer $currentAccessToken")
                            }

                            if (result.status == HttpStatusCode.OK) {
                                val tokensResponse = result.body<RefreshTokenResponse>()

                                // Сохраняем новые токены в DataStore
                                encryptedDataStore.saveToken(tokensResponse.userToken)
                                encryptedDataStore.saveRefreshToken(tokensResponse.userRefreshToken)

                                // Возвращаем новые токены для текущего упавшего запроса
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
                header("Local", if(Locale.getDefault().toString().contains("RU")){"RU"} else {"ENG"})
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
        }
    }
}