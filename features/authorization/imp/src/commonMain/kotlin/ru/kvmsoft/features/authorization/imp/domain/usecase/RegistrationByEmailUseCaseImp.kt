package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.RegistrationByEmailUseCase
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository

class RegistrationByEmailUseCaseImp(private val repository: AuthorizationRepository):
    RegistrationByEmailUseCase {
    override suspend fun registration(email: String): RegistrationByEmailDomain {
        return repository.registrationByEmail(email)
    }
}