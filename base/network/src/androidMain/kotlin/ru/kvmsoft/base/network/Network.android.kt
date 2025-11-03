package ru.kvmsoft.base.network

import android.R.attr.tag
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.util.AttributeKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
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
import java.lang.reflect.Method
import java.util.Locale

@OptIn(ExperimentalSerializationApi::class)
actual val client: HttpClient
    get() = HttpClient(OkHttp) {
        //encrypted data store
        val encryptedDataStore: EncryptedDataStore by inject(EncryptedDataStore::class.java)
        val scope = CoroutineScope(Job() + Dispatchers.Default)
        //Timeout plugin to set up timeout milliseconds for client
        install(HttpTimeout) {
            socketTimeoutMillis = 180_000
            requestTimeoutMillis = 180_000
        }
        //Logging plugin combined with kermit(KMP Logger library)
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Log.i("KtorClient", message)
                }
            }
        }
        install(Auth) {
            scope.launch {
                encryptedDataStore.accessToken.combine(encryptedDataStore.refreshToken) { accessToken, refreshToken ->
                    Pair(accessToken, refreshToken)
                }.collect { (accessToken, refreshToken) ->

                    bearer {
                        // Load initial tokens (access and refresh) from secure storage
                        loadTokens {
                            if (accessToken.isNotEmpty() && refreshToken.isNotEmpty()) {
                                BearerTokens(accessToken, refreshToken)
                            } else {
                                null // No tokens available, user needs to log in
                            }
                        }
                        // Define the refresh token logic
                        refreshTokens {
                            var tokensResponse = RefreshTokenResponse(errorMsg = "")
                            // this: RefreshTokensParams
                            // Call your API to get new tokens using the refresh token
                            val newTokens = try {

                                val result = with(client) {
                                    post("${getBaseUrl()}${RefreshEndpoints.refreshToken}") {
                                        setBody(RefreshTokenRequest(refreshToken = refreshToken))
                                        header(HttpHeaders.Authorization, accessToken)
                                    }
                                }
                                if (result.status == HttpStatusCode.OK) {
                                    tokensResponse = result.body<RefreshTokenResponse>()
                                } else {
                                    throw NetworkError.Unauthorized()
                                }
                            } catch (e: Exception) {
                                // Handle refresh token failure (e.g., log out user)
                                encryptedDataStore.clearUserData()
                                throw NetworkError.Unauthorized()
                            }

                            // Store new tokens securely
//                            secureStorage.setTokens(newTokens.accessToken, newTokens.refreshToken)
                            encryptedDataStore.saveToken(tokensResponse.userToken)
                            encryptedDataStore.saveRefreshToken(tokensResponse.userRefreshToken)

                            // Return the new tokens
                            BearerTokens(tokensResponse.userToken, tokensResponse.userRefreshToken)
                        }
                    }
                }
            }
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
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
    }