package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenOfflineLogClearUseCase
import ru.kvmsoft.features.authorization.imp.data.AuthorizationRepository

class AuthByTokenOfflineLogClearUseCaseImp(private val repository: AuthorizationRepository): AuthByTokenOfflineLogClearUseCase {
    override suspend fun logOfflineAuthBytTokenClear() {
        repository.authByTokenOfflineLogClear()
    }
}