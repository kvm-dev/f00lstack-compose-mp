package ru.kvmsoft.features.networkconnection.imp.domain.usecase

import io.ktor.client.plugins.timeout
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import ru.kvmsoft.base.network.client
import ru.kvmsoft.base.network.utils.disableAuthKey
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class GetNetworkStateUseCaseImp: GetNetworkStateUseCase {
    override suspend fun isNetworkAvailable(): Boolean{
            return try {
                client.get("https://foolstack.ru") {
                    attributes.put(disableAuthKey, true)
                    timeout {
                        requestTimeoutMillis = 15000 // 5 seconds
                    }
                }.status.isSuccess()
            } catch (e: Exception) {
                false
            }
    }
}