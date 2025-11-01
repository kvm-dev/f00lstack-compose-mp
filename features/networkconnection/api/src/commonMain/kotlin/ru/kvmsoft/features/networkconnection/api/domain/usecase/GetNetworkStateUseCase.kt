package ru.kvmsoft.features.networkconnection.api.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetNetworkStateUseCase {
    suspend fun isNetworkAvailable():Boolean
}