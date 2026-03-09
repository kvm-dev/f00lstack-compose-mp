package ru.kvmsoft.features.tests.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.tests.imp.domain.TestInnerScreenInteractor
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsInnerScreenSideEffects
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsInnerScreenViewState

class TestsInnerScreenViewModel(private val interactor: TestInnerScreenInteractor) : BaseViewModel<TestsInnerScreenViewState, TestsInnerScreenSideEffects>(
    TestsInnerScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}