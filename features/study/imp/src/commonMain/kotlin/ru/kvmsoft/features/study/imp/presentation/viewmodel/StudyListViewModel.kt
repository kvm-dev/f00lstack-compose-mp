package ru.kvmsoft.features.study.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.study.imp.domain.StudyListScreenInteractor
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenSideEffects
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenViewState

class StudyListViewModel(private val interactor: StudyListScreenInteractor) : BaseViewModel<StudyListScreenViewState, StudyListScreenSideEffects>(
    StudyListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}