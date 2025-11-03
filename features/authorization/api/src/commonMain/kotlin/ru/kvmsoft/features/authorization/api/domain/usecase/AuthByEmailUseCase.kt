package ru.kvmsoft.features.authorization.api.domain.usecase

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain

interface AuthByEmailUseCase {

    suspend fun auth(email: String, code: String): AuthByEmailDomain
}