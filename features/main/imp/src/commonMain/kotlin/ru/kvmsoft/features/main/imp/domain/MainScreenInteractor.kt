package ru.kvmsoft.features.main.imp.domain

import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase

class MainScreenInteractor(private val getProfileUseCase: GetProfileUseCase) {
    suspend fun getProfile() = getProfileUseCase.getProfile()
}