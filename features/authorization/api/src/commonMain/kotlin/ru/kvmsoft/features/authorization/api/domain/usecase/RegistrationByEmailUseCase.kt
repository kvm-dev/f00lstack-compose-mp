package ru.kvmsoft.features.authorization.api.domain.usecase

import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain

interface RegistrationByEmailUseCase {

    suspend fun registration(email: String): RegistrationByEmailDomain
}