package ru.kvmsoft.features.authorization.api.domain.usecase

import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain

interface ConfirmAuthAndRegUseCase {

    suspend fun confirm(email: String, code: String): ConfirmAuthAndRegDomain
}