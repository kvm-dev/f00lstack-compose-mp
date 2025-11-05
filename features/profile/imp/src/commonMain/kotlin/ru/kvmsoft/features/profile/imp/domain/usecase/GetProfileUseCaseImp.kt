package ru.kvmsoft.features.profile.imp.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository

class GetProfileUseCaseImp(private val repository: ProfileRepository): GetProfileUseCase {

    private val _profile = MutableStateFlow<ResultState<ProfileDomain>>(
        ResultState.Idle)

    override val profileState = _profile.asStateFlow()
    override suspend fun getProfile(fromLocal: Boolean): ProfileDomain {
        _profile.tryEmit(ResultState.Loading)
        return if(fromLocal){
            val cachedProfile = repository.getProfileFromLocal()
            _profile.tryEmit(ResultState.Success(cachedProfile))
            cachedProfile
        }
        else{
            val networkResult = repository.getProfileFromServer()
            _profile.tryEmit(ResultState.Success(networkResult))
             networkResult
        }
    }

    override suspend fun clearState() {
        _profile.tryEmit(ResultState.Success(null))
    }
}