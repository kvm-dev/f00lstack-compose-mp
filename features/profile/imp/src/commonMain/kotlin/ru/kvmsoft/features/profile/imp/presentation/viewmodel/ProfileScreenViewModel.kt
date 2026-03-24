package ru.kvmsoft.features.profile.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.profile.imp.domain.ProfileScreenInteractor
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreenSideEffects
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreenViewState

class ProfileScreenViewModel(private val interactor: ProfileScreenInteractor) : BaseViewModel<ProfileScreenViewState, ProfileScreenSideEffects>(
    ProfileScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}