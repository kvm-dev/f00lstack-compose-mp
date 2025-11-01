package ru.kvmsoft.features.professions.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.professions.imp.domain.ProfessionsScreenInteractor
import ru.kvmsoft.features.professions.imp.presentation.ui.ProfessionsScreenViewState

class ProfessionsScreenViewModel(private val interactor: ProfessionsScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<ProfessionsScreenViewState>(
        ProfessionsScreenViewState.LoadingState
    )

    val uiState: StateFlow<ProfessionsScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        if(progressState.value == ProgressState.LOADING){
            launch(Dispatchers.IO) {
//                interactor.userState.collect { userState->
//                    _uiState.update { interactor.getCurrentState(state = userState, currentPosition = currentPosition) }
            }
        }
    }
}
