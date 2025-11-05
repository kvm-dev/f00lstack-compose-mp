package ru.kvmsoft.features.profile.api.domain.usecase

import ru.kvmsoft.features.profile.api.model.UpdatePhotoResponseDomain

interface UpdatePhotoUseCase {
    suspend fun updatePhoto(photo: ByteArray): UpdatePhotoResponseDomain
}