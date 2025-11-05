package ru.kvmsoft.features.profile.api.domain.usecase

import ru.kvmsoft.features.profile.api.model.UpdateNameResponseDomain

interface UpdateNameUseCase {
    suspend fun updateName(userName: String): UpdateNameResponseDomain
}