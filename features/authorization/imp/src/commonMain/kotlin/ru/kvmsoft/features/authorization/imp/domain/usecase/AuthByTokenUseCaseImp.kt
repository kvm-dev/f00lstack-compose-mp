package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenUseCase
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.imp.data.AuthorizationRepository

class AuthByTokenUseCaseImp(private val repository: AuthorizationRepository): AuthByTokenUseCase {
    override suspend fun auth(): AuthByTokenDomain {
        return repository.authByToken()
    }
}