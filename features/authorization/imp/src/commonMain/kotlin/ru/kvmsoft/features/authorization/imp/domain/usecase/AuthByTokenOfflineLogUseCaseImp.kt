package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenOfflineLogUseCase
import ru.kvmsoft.features.authorization.imp.data.AuthorizationRepository

class AuthByTokenOfflineLogUseCaseImp(private val repository: AuthorizationRepository):
    AuthByTokenOfflineLogUseCase {
    override suspend fun logOfflineAuthBytToken() {
        repository.authByTokenOfflineLog()
    }
}