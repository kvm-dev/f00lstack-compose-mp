package ru.kvmsoft.features.interview.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.interview.imp.domain.InterviewListScreenInteractor
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewListScreenSideEffects
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewListScreenViewState

class InterviewListScreenViewModel(private val interactor: InterviewListScreenInteractor) : BaseViewModel<InterviewListScreenViewState, InterviewListScreenSideEffects>(
    InterviewListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}