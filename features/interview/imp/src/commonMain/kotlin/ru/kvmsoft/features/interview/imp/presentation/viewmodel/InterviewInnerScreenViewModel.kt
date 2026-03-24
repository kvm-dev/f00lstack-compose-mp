package ru.kvmsoft.features.interview.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.interview.imp.domain.InterviewInnerScreenInteractor
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewInnerScreenSideEffects
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewInnerScreenViewState

class InterviewInnerScreenViewModel(private val interactor: InterviewInnerScreenInteractor) : BaseViewModel<InterviewInnerScreenViewState, InterviewInnerScreenSideEffects>(
    InterviewInnerScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}