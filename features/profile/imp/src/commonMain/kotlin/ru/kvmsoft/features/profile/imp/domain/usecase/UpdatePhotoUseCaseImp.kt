package ru.kvmsoft.features.profile.imp.domain.usecase

import ru.kvmsoft.features.profile.api.domain.usecase.UpdatePhotoUseCase
import ru.kvmsoft.features.profile.api.model.UpdatePhotoResponseDomain
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class UpdatePhotoUseCaseImp(private val repository: ProfileRepository): UpdatePhotoUseCase {

    override suspend fun updatePhoto(photo: ByteArray): UpdatePhotoResponseDomain {
        return repository.updatePhoto(photo = photo)
    }
}