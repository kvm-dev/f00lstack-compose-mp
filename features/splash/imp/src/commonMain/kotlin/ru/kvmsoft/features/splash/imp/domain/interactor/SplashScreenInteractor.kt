package ru.kvmsoft.features.splash.imp.domain.interactor

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState

class SplashScreenInteractor(private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase) {

    val langState = getCurrentLanguageUseCase.langState

     fun getCurrentLang(){
        getCurrentLanguageUseCase.getLang()
    }

    fun getState(langState: ResultState<CurrentLanguageDomain>): SplashScreenViewState{
        return when(langState){
            ResultState.Idle -> {
                SplashScreenViewState.LoadingState
            }
            ResultState.Loading -> {
                SplashScreenViewState.LoadingState
            }
            is ResultState.Success-> {
                SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN)
            }
        }
    }
}