package ru.kvmsoft.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

open class BaseViewModel() : ViewModel() {
    private val _progressState = MutableStateFlow(ProgressState.IDLE)
    val progressState: StateFlow<ProgressState> = _progressState.asStateFlow()


    private val _currentLangState = MutableStateFlow(CurrentLanguageDomain.EN)
    val currentLangState: StateFlow<CurrentLanguageDomain> = _currentLangState.asStateFlow()

    fun updateState(state: ProgressState){
        _progressState.value = state
    }

    fun updateLangState(langState: CurrentLanguageDomain){
        _currentLangState.value = langState
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //something error
    }

    fun finishApplication() = closeApp()

    val supervisorJob = SupervisorJob()
}