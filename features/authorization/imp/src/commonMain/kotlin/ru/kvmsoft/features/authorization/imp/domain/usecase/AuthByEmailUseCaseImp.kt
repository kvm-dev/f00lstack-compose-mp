package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByEmailUseCase
import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.imp.data.AuthorizationRepository

class AuthByEmailUseCaseImp(private val repository: AuthorizationRepository): AuthByEmailUseCase {
    override suspend fun auth(
        email: String,
        code: String
    ): AuthByEmailDomain {
       return repository.authByEmail(email = email, code = code)
    }
}