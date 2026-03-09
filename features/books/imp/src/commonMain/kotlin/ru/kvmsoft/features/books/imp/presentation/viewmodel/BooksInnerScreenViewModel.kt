package ru.kvmsoft.features.books.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.books.imp.domain.BooksInnerScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenSideEffects
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenViewState

class BooksInnerScreenViewModel(private val interactor: BooksInnerScreenInteractor) : BaseViewModel<BooksInnerScreenViewState, BooksInnerScreenSideEffects>(
    BooksInnerScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}