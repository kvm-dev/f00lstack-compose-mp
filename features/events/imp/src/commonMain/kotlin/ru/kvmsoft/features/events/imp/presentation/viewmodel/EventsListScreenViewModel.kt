package ru.kvmsoft.features.events.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.events.imp.domain.EventsListScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenIntents
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenIntents
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenSideEffects
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class EventsListScreenViewModel(private val interactor: EventsListScreenInteractor) : BaseViewModel<EventsListScreenViewState, EventsListScreenSideEffects>(
    EventsListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)


    fun initViewModel() = orbitIntent {
        scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            reduce { EventsListScreenViewState.LoadingState }
           currentLangState.collect {
                    val currentState = interactor.checkState(
                        lang = it
                    )
                    reduce { currentState }
            }
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            EventsListScreenIntents.InitViewModelIntent -> initViewModel()
            is EventsListScreenIntents.UpdateFiltersIntent -> orbitIntent {
                if(intent.subName.isNotEmpty()){
                    val current = state as EventsListScreenViewState.SuccessState
                    val selectedFilters = HashSet<String>()
                    current.selectedFilters.forEach { sub->
                        selectedFilters.add(sub)
                    }
                    if(selectedFilters.contains(intent.subName)){
                        selectedFilters.remove(intent.subName)
                    }
                    else{
                        selectedFilters.add(intent.subName)
                    }
                    reduce { current.copy(selectedFilters = selectedFilters.toList()) }
                }
            }

            is EventsListScreenIntents.NavigateToEventDetailsIntent -> orbitIntent {
                postSideEffect(EventsListScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN)
            }
            EventsListScreenIntents.OpenChatIntent -> orbitIntent { interactor.openChat() }

            EventsListScreenIntents.RefreshIntent ->  orbitIntent {
                postSideEffect(EventsListScreenSideEffects.REFRESH_SCREEN)
            }
        }
    }
}