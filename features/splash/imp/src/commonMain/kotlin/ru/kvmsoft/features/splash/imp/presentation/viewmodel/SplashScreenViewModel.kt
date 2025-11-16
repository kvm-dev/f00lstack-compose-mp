package ru.kvmsoft.features.splash.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.splash.imp.domain.interactor.SplashScreenInteractor
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState

class SplashScreenViewModel(private val interactor: SplashScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow(interactor.defaultViewState())
    private val loadingTime = 5000L //not required, but can be used to see the animation a little bit.


    val uiState: StateFlow<SplashScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
            launch {
                val connection = interactor.isNetworkAvailable()
                interactor.getCurrentLang()
                interactor.langState.zip(interactor.userToken) { langState, userToken ->
                    Pair(langState, userToken)
                }.collectLatest { result ->
                    if (result.first is ResultState.Success) {
                        if(result.second.isNotEmpty()){
                            val profile = if(connection) interactor.getProfile() else interactor.getProfileFromLocal()
                            _uiState.update { uiState.value.copy(
                                language = (result.first as ResultState.Success<CurrentLanguageDomain>).data?: CurrentLanguageDomain.EN,
                                userToken = result.second,
                                profile = profile,
                                isConnectionAvailable = connection
                            ) }
                        }
                        else{
                            _uiState.update { uiState.value.copy(
                                language = (result.first as ResultState.Success<CurrentLanguageDomain>).data?: CurrentLanguageDomain.EN,
                                userToken = result.second,
                                profile = null,
                                isConnectionAvailable = connection
                            ) }
                        }
                        updateLangState(
                            (result.first as ResultState.Success<CurrentLanguageDomain>).data
                                ?: CurrentLanguageDomain.EN
                        )
                    } else {
                        updateLangState(CurrentLanguageDomain.EN)
                    }
                    updateState(ProgressState.LOADING)
                }
            }
    }

     fun finishLoading() = with(viewModelScope + coroutineExceptionHandler){
             launch {
                delay(loadingTime)
                 updateState(ProgressState.COMPLETED)
             }
     }

    fun goToAuthorize() = with(viewModelScope){
        launch {
            interactor.clearUserData()
        }
    }
}
