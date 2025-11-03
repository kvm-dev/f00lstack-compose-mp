package ru.kvmsoft.features.authorization.api.domain.usecase

import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain

interface AuthByTokenUseCase {

    suspend fun auth(): AuthByTokenDomain

}