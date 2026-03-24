package ru.kvmsoft.features.books.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.books.imp.domain.BooksListScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenSideEffects
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenViewState

class BooksListScreenViewModel(private val interactor: BooksListScreenInteractor) : BaseViewModel<BooksListScreenViewState, BooksListScreenSideEffects>(
    BooksListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}