package ru.kvmsoft.features.main.imp.presentation.viewmodel

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
import ru.kvmsoft.features.main.imp.domain.MainScreenInteractor
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenViewState

class MainScreenViewModel(private val interactor: MainScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<MainScreenViewState>(
        MainScreenViewState.LoadingState
    )

    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
            launch(Dispatchers.IO) {
                //todo test
                interactor.getProfile()
            }
        }
    }
