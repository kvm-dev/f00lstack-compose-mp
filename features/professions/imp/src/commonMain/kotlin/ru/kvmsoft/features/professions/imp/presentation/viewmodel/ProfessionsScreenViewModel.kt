package ru.kvmsoft.features.professions.imp.presentation.viewmodel

import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.professions.imp.domain.ProfessionsScreenInteractor
import ru.kvmsoft.features.professions.imp.presentation.ui.ProfessionsScreenSideEffects
import ru.kvmsoft.features.professions.imp.presentation.ui.ProfessionsScreenViewState

class ProfessionsScreenViewModel(private val interactor: ProfessionsScreenInteractor) : BaseViewModel<ProfessionsScreenViewState, ProfessionsScreenSideEffects>(
    ProfessionsScreenViewState.LoadingState
) {

    fun initViewModel() {

    }

    override fun intentHandler(intent: Any) {

    }
}