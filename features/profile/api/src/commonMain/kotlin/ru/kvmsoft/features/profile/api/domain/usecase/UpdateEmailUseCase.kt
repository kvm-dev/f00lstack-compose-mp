package ru.kvmsoft.features.profile.api.domain.usecase

import ru.kvmsoft.features.profile.api.model.UpdateEmailResponseDomain

interface UpdateEmailUseCase {
    suspend fun updateEmail(email: String): UpdateEmailResponseDomain
}