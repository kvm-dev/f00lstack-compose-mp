package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.ConfirmAuthAndRegUseCase
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository

class ConfirmAuthAndRegUseCaseImp(private val repository: AuthorizationRepository):
    ConfirmAuthAndRegUseCase {
    override suspend fun confirm(email: String, code: String): ConfirmAuthAndRegDomain {
        return repository.confirmAuthAndReg(email = email, code = code)
    }
}