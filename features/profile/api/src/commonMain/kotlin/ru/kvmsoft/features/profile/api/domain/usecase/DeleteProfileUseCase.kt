package ru.kvmsoft.features.profile.api.domain.usecase

import ru.kvmsoft.features.profile.api.model.DeleteProfileResponseDomain


interface DeleteProfileUseCase {
    suspend fun deleteProfile(): DeleteProfileResponseDomain
}