package ru.kvmsoft.features.profile.imp.domain.usecase

import ru.kvmsoft.features.profile.api.domain.usecase.DeleteProfileUseCase
import ru.kvmsoft.features.profile.api.model.DeleteProfileResponseDomain
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class DeleteProfileUseCaseImp(private val repository: ProfileRepository): DeleteProfileUseCase {

    override suspend fun deleteProfile(): DeleteProfileResponseDomain {
        return repository.deleteProfile()
    }
}