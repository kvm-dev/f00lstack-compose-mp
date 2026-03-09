package ru.kvmsoft.features.main.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.domain.MainScreenInteractor
import ru.kvmsoft.features.main.imp.model.MainScreenData
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenIntents
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenSideEffects
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenViewState

class MainScreenViewModel(private val interactor: MainScreenInteractor) : BaseViewModel<MainScreenViewState, MainScreenSideEffects>(
    MainScreenViewState.LoadingState){

    val scope = (viewModelScope + coroutineExceptionHandler)

    private val _isKnowHowToUseSlider = MutableStateFlow(false)

    fun initViewModel() = orbitIntent {
            scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                reduce { MainScreenViewState.LoadingState }
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
                        reduce { currentState }
                    }
                    if (it.lang is ResultState.Idle || it.profile is ResultState.Idle) {
                        interactor.getCurrentLang()
                        if (interactor.isNetworkAvailable()) {
                            interactor.getProfile()
                        } else {
                            interactor.getProfile(true)
                        }
                        reduce { MainScreenViewState.LoadingState }
                    }
                    if (it.lang is ResultState.Loading || it.profile is ResultState.Loading) {
                        reduce { MainScreenViewState.LoadingState }
                    }
            }
        }
}

    override fun intentHandler(intent: Any) {
        when(intent){
            MainScreenIntents.GoToAuthorizationIntent-> orbitIntent {
                scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                    interactor.clearUserData()
                }
            }
            MainScreenIntents.InitViewModelIntent -> initViewModel()
            MainScreenIntents.UpdateEventsSliderHintStateIntent-> orbitIntent {
                scope.launch(Dispatchers.IO + coroutineExceptionHandler){
                    interactor.updateEventsSliderHintState()
                }
            }
            is MainScreenIntents.NavigateToEventDetailsIntent -> orbitIntent {
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN)
            }
        }
    }
}
