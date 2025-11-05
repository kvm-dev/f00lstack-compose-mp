package ru.kvmsoft.features.profile.imp.domain.usecase

import ru.kvmsoft.features.profile.api.domain.usecase.LogoutUseCase
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class LogoutUseCaseImp(private val repository: ProfileRepository): LogoutUseCase {
    override suspend fun logout() {
        repository.logout()
    }
}