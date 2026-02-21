package ru.kvmsoft.features.events.imp.presentation.viewmodel

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
import ru.kvmsoft.features.events.imp.domain.EventsListScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class EventsListScreenViewModel(private val interactor: EventsListScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<EventsListScreenViewState>(
        EventsListScreenViewState.LoadingState(lang = interactor.getCurrentLang())
    )

    private val _isKnowHowToUseSlider = MutableStateFlow(false)

    val uiState: StateFlow<EventsListScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        if(progressState.value == ProgressState.IDLE) {
            launch(Dispatchers.IO) {
                interactor.langState.collect {
                    if (progressState.value == ProgressState.IDLE) {
                        if (it is ResultState.Success) {
                            val lang = it.data
                            val currentState = interactor.checkState(
                                lang = lang ?: CurrentLanguageDomain.EN)
                            _uiState.update { currentState }
                            updateState(ProgressState.COMPLETED)
                        }
                        else{
                            _uiState.update { EventsListScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
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

    fun updateFilters(subName: String){
        if(subName.isNotEmpty()){
            val current = uiState.value as EventsListScreenViewState.SuccessState
            val selectedFilters = HashSet<String>()
            current.selectedFilters.forEach { sub->
                selectedFilters.add(sub)
            }
            if(selectedFilters.contains(subName)){
                selectedFilters.remove(subName)
            }
            else{
                selectedFilters.add(subName)
            }

            _uiState.update { current.copy(selectedFilters = selectedFilters.toList()) }
        }
    }


    fun refresh() = with(viewModelScope + coroutineExceptionHandler) {
        launch (context = Dispatchers.IO) {
            if(interactor.isNetworkAvailable()){
                _uiState.update { EventsListScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                interactor.langState.collect {
                        if (it is ResultState.Success) {
                            val lang = it.data
                            val currentState = interactor.checkState(
                                lang = lang ?: CurrentLanguageDomain.EN)
                            _uiState.update { currentState }
                        }
                        else{
                            _uiState.update { EventsListScreenViewState.LoadingState(lang = interactor.getCurrentLang()) }
                        }
                }
            }
        }
    }
}