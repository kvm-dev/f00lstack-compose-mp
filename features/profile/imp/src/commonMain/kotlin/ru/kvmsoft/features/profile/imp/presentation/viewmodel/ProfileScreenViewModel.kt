package ru.kvmsoft.features.profile.imp.presentation.viewmodel

import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.profile.imp.domain.ProfileScreenInteractor
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreenSideEffects
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreenViewState

class ProfileScreenViewModel(private val interactor: ProfileScreenInteractor) : BaseViewModel<ProfileScreenViewState, ProfileScreenSideEffects>(
    ProfileScreenViewState.LoadingState
) {

    fun initViewModel()  {

    }

    override fun intentHandler(intent: Any) {

    }
}