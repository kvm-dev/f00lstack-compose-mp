package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.IsUserExistUseCase
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository

class IsUserExistUseCaseImp(private val repository: AuthorizationRepository): IsUserExistUseCase {
    override suspend fun isUserExist(email: String): IsUserExistDomain {
        return repository.isUserExist(email = email)
    }
}