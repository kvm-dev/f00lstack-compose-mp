package ru.kvmsoft.features.splash.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    val uiState: StateFlow<SplashScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
            launch(Dispatchers.IO) {
                interactor.langState.collect { langState ->
                    _uiState.update { interactor.getState(langState = langState) }
                    if(langState is ResultState.Success){
                        updateLangState(langState.data?: CurrentLanguageDomain.EN)
                    }
                    updateState(ProgressState.COMPLETED)
                }
            }
        if (progressState.value == ProgressState.IDLE) {
            interactor.getCurrentLang()
        }
    }
}

//    fun updateUserPosition() = with(viewModelScope + coroutineExceptionHandler){
//        launch(Dispatchers.IO) {
//            val currentPosition = interactor.getCurrentUserLocation()
//            _uiState.value.copy(currentStreetName = "Ул. Бела-Куна 9", currentPosition = currentPosition)
//        }
//    }

//    fun updateUserPosition() = with(viewModelScope + coroutineExceptionHandler){
//        val currentPosition = interactor.getCurrentUserLocation()
//        _uiState.update { NewsViewState.LoadingState(lang = lang) }
//        launch {
//            if(interactor.isConnectionAvailable()){
//                interactor.getNewsFromServer()
//            }
//            else{
//                interactor.getNewsFromLocal()
//            }
//            updateState(ProgressState.LOADING)
//            initViewModel()
//        }
//    }

//    fun navigateToSingleNews(navController: NavController, newsId: Int, newsDestination: String){
//        val route = "$newsDestination/{newsId}"
//        navController.navigate(
//            route.replace(
//                oldValue = "{newsId}",
//                newValue = newsId.toString()
//            )
//        )
//    }

//    fun isConnectionAvailable() = interactor.isConnectionAvailable()
//}