package ru.kvmsoft.features.profile.imp.domain.usecase

import ru.kvmsoft.features.profile.api.domain.usecase.UpdateEmailUseCase
import ru.kvmsoft.features.profile.api.model.UpdateEmailResponseDomain
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class UpdateEmailUseCaseImp(private val repository: ProfileRepository): UpdateEmailUseCase {
    override suspend fun updateEmail(email: String): UpdateEmailResponseDomain {
        return repository.updateEmail(email = email)
    }
}