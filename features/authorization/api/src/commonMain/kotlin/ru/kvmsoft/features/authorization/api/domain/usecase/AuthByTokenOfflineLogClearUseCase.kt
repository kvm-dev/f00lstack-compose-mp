package ru.kvmsoft.features.authorization.api.domain.usecase

interface AuthByTokenOfflineLogClearUseCase {

    suspend fun logOfflineAuthBytTokenClear()
}