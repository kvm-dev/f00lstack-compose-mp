package ru.kvmsoft.features.splash.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.splash.imp.domain.interactor.SplashScreenInteractor
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenIntents
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenSideEffects

class SplashScreenViewModel(private val interactor: SplashScreenInteractor) : BaseViewModel<SplashScreenViewState, SplashScreenSideEffects>(
    SplashScreenViewState.Idle
) {
    val scope = (viewModelScope + coroutineExceptionHandler)


    private fun loadData() = orbitIntent {
        scope.launch {
            val connection = interactor.isNetworkAvailable()
            interactor.getCurrentLang()
            interactor.langState.zip(interactor.userToken) { langState, userToken ->
                Pair(langState, userToken)
            }.collectLatest { result ->
                if (result.first is ResultState.Success) {
                    updateLangState(
                        (result.first as ResultState.Success<CurrentLanguageDomain>).data
                            ?: CurrentLanguageDomain.EN
                    )
                    if (result.second.isNotEmpty()) {
                        val profile =
                            if (connection) interactor.getProfile() else interactor.getProfileFromLocal()
                        updateProfileState(profile)
                        launch {
                            delay(5000L)
                            postSideEffect(SplashScreenSideEffects.NAVIGATE_TO_AUTHORIZED_ZONE)
                        }
                    } else {
                        launch {
                            delay(5000L)
                            postSideEffect(SplashScreenSideEffects.NAVIGATE_TO_AUTHORIZATION_ZONE)
                        }
                    }
                    updateLangState(
                        (result.first as ResultState.Success<CurrentLanguageDomain>).data
                            ?: CurrentLanguageDomain.EN
                    )
                } else {
                    updateLangState(CurrentLanguageDomain.EN)
                }
                reduce {
                    SplashScreenViewState.Loading
                }
            }
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            SplashScreenIntents.InitViewModelIntent -> loadData()
        }
    }
}
