package ru.kvmsoft.features.tests.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.tests.imp.domain.TestInnerScreenInteractor
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsListScreenSideEffects
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsListScreenViewState

class TestsListScreenViewModel(private val interactor: TestInnerScreenInteractor) : BaseViewModel<TestsListScreenViewState, TestsListScreenSideEffects>(
    TestsListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}