package ru.kvmsoft.features.profile.api.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.profile.api.model.ProfileDomain

interface GetProfileUseCase {

    val profileState: StateFlow<ResultState<ProfileDomain>>
    suspend fun getProfile(fromLocal: Boolean = false):ProfileDomain

    suspend fun clearState()
}