package ru.kvmsoft.features.splash.imp.presentation.viewmodel

import androidx.compose.ui.graphics.vector.Path
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.splash.imp.domain.interactor.SplashScreenInteractor
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState

class SplashScreenViewModel(private val interactor: SplashScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<SplashScreenViewState>(
        SplashScreenViewState.LoadingState
    )
    private val loadingTime = 5000L //not required, but can be used to see the animation a little bit.

    val uiState: StateFlow<SplashScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        launch(Dispatchers.IO) {
            interactor.getCurrentLang()
            interactor.langState.collect { langState ->
                if (langState is ResultState.Success) {
                    updateLangState(langState.data?: CurrentLanguageDomain.EN)
                    _uiState.update {
                        SplashScreenViewState.SuccessState(language = currentLangState.value)
                    }
                }
            }
        }
        updateState(ProgressState.LOADING)
    }

        fun checkState() = with(viewModelScope + coroutineExceptionHandler) {
            launch(Dispatchers.IO) {
                delay(loadingTime)
                interactor.langState.combine(interactor.userToken) { langState, userToken ->
                    Pair(
                        langState,
                        userToken
                    )
                }.collect { data ->
                    val state = interactor.getState(
                        langState = data.first,
                        withToken = data.second.isNotEmpty()
                    )
                    _uiState.update { state }
                    updateState(ProgressState.COMPLETED)
                }
            }
        }
    }
