package ru.kvmsoft.features.profile.imp.domain.usecase

import ru.kvmsoft.features.profile.api.domain.usecase.UpdateNameUseCase
import ru.kvmsoft.features.profile.api.model.UpdateNameResponseDomain
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class UpdateNameUseCaseImp(private val repository: ProfileRepository): UpdateNameUseCase {
    override suspend fun updateName(userName: String): UpdateNameResponseDomain {
        return repository.updateName(name = userName)
    }
}