package ru.kvmsoft.base.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.localeIdentifier
import ru.kvmsoft.base.network.model.PlatformType
import ru.kvmsoft.base.network.model.UserType
import ru.kvmsoft.base.network.utils.getCurrentVersion
import ru.kvmsoft.base.network.utils.getPlatform
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore

@OptIn(ExperimentalSerializationApi::class)
actual val client: HttpClient
    get() = HttpClient(Darwin) {
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
                    println("KtorClient $message")
                }
            }
        }

//        // Install the HttpResponseValidator
//        HttpResponseValidator {
//            // Validate successful responses (2xx)
//            validateResponse { response ->
//                if (response.status.isSuccess()) {
//                    println("Successful response: ${response.status}")
//                }
//            }
//
//            // Handle exceptions that occur during response processing
//            handleResponseExceptionWithRequest { exception, request ->
//                if (exception is ClientRequestException) {
//                    val response = exception.response
//                    if (response.status == HttpStatusCode.Unauthorized) {
//                        println("Authentication error: ${response.status}")
//                        // Example: Try to refresh token or redirect to login
//                        // refreshToken()
//                    } else if (response.status.isClientError() || response.status.isServerError()) {
//                        try {
//                            val errorBody = response.body<CustomError>()
//                            throw CustomResponseException(response, "API Error: Code ${errorBody.code}, Message: ${errorBody.message}")
//                        } catch (e: Exception) {
//                            // If the error body cannot be parsed as CustomError
//                            throw CustomResponseException(response, "Unexpected error format: ${response.status}")
//                        }
//                    }
//                } else {
//                    // Handle other types of exceptions (e.g., network errors)
//                    println("Network or other error: ${exception.localizedMessage}")
//                    throw exception // Re-throw to propagate the exception
//                }
//            }
//        }


        install(ResponseObserver) {
            onResponse { response ->
                println("HTTP status: ${response.status.value}")
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(
                "Local", if (NSLocale.currentLocale.localeIdentifier.lowercase().contains("ru")) {
                    "RU"
                } else {
                    "ENG"
                }
            )
            header("Platform", if(getPlatform() == PlatformType.ANDROID) "android" else "ios")
            header("Version", getCurrentVersion())
            header(UserType.Client().key, UserType.Client().type)
        }
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