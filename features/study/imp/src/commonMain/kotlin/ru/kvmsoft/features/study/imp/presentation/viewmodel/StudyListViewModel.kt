package ru.kvmsoft.features.study.imp.presentation.viewmodel

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
import ru.kvmsoft.features.study.imp.domain.StudyListScreenInteractor
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenViewState

class StudyListViewModel(private val interactor: StudyListScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<StudyListScreenViewState>(
        StudyListScreenViewState.LoadingState
    )

    val uiState: StateFlow<StudyListScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        if(progressState.value == ProgressState.LOADING){
            launch(Dispatchers.IO) {
//                interactor.userState.collect { userState->
//                    _uiState.update { interactor.getCurrentState(state = userState, currentPosition = currentPosition) }
            }
        }
    }
}
