package ru.kvmsoft.features.main.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.domain.MainScreenInteractor
import ru.kvmsoft.features.main.imp.model.MainScreenData
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenViewState

class MainScreenViewModel(private val interactor: MainScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<MainScreenViewState>(
        MainScreenViewState.LoadingState(lang = interactor.getCurrentLang())
    )

    private val _isKnowHowToUseSlider = MutableStateFlow(false)

    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        if(progressState.value == ProgressState.IDLE) {
            launch(Dispatchers.IO) {
                progressState.value == ProgressState.LOADING
                combine(interactor.langState, interactor.profile, interactor.isKnowHowToUseEventSlider) { lang, profile, isKnowHowToUseEventsSlider ->
                    _isKnowHowToUseSlider.update { isKnowHowToUseEventsSlider }
                    MainScreenData(
                        lang = lang,
                        profile = profile,
                        isKnowHowToUseSlider = isKnowHowToUseEventsSlider
                    )
                }.collect {
                    if (progressState.value == ProgressState.IDLE) {
                    if (it.lang is ResultState.Success && it.profile is ResultState.Success) {
                        val lang = it.lang.data
                        val profile = it.profile.data
                        val isKnowHowToUseSlider = it.isKnowHowToUseSlider
                        val currentState = interactor.checkState(
                            lang = lang ?: CurrentLanguageDomain.EN,
                            profileDomain = profile,
                            isKnowHowToUseSlider = isKnowHowToUseSlider
                        )
                        _uiState.update { currentState }
                        updateState(ProgressState.COMPLETED)
                    }
                    if (it.lang is ResultState.Idle || it.profile is ResultState.Idle) {
                        interactor.getCurrentLang()
                        if (interactor.isNetworkAvailable()) {
                            interactor.getProfile()
                        } else {
                            interactor.getProfile(true)
                        }
                        _uiState.update { MainScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                    }
                    if (it.lang is ResultState.Loading || it.profile is ResultState.Loading) {
                        _uiState.update { MainScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                    }
                }
            }
        }
    }
}

    fun goToAuthorize() = with(viewModelScope) {
        launch {
            interactor.clearUserData()
        }
    }

    fun navigateToEvent(navController: NavController, eventId: Int, eventDestination: String) {
        val route = "$eventDestination/{eventId}"
        navController.navigate(
            route.replace(
                oldValue = "{eventId}",
                newValue = eventId.toString()
            )
        )
    }

    fun updateEventsSliderHintState() = with(viewModelScope + coroutineExceptionHandler){
        launch (context = Dispatchers.IO) {
            interactor.updateEventsSliderHintState()
        }
    }

    fun refresh() = with(viewModelScope + coroutineExceptionHandler) {
        launch (context = Dispatchers.IO) {
            if(interactor.isNetworkAvailable()){
                _uiState.update { MainScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                combine(interactor.langState, interactor.profile, interactor.isKnowHowToUseEventSlider) { lang, profile, isKnowHowToUseEventsSlider ->
                    _isKnowHowToUseSlider.update { isKnowHowToUseEventsSlider }
                    MainScreenData(
                        lang = lang,
                        profile = profile,
                        isKnowHowToUseSlider = isKnowHowToUseEventsSlider
                    )
                }.collect {
                        if (it.lang is ResultState.Success && it.profile is ResultState.Success) {
                            val lang = it.lang.data
                            val profile = it.profile.data
                            val isKnowHowToUseSlider = it.isKnowHowToUseSlider
                            val currentState = interactor.checkState(
                                lang = lang ?: CurrentLanguageDomain.EN,
                                profileDomain = profile,
                                isKnowHowToUseSlider = isKnowHowToUseSlider
                            )
                            _uiState.update { currentState }
                            updateState(ProgressState.COMPLETED)
                        }
                        if (it.lang is ResultState.Idle || it.profile is ResultState.Idle) {
                            interactor.getCurrentLang()
                            if (interactor.isNetworkAvailable()) {
                                interactor.getProfile()
                            } else {
                                interactor.getProfile(true)
                            }
                            _uiState.update { MainScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                        }
                        if (it.lang is ResultState.Loading || it.profile is ResultState.Loading) {
                            _uiState.update { MainScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                        }
                }
            }
        }
    }

     fun getCurrentLang()  = interactor.getCurrentLang()
}
