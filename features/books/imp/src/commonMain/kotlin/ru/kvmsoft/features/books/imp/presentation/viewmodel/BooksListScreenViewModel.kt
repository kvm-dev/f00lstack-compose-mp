package ru.kvmsoft.features.books.imp.presentation.viewmodel

import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.books.imp.domain.BooksListScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenSideEffects
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenViewState

class BooksListScreenViewModel(private val interactor: BooksListScreenInteractor) : BaseViewModel<BooksListScreenViewState, BooksListScreenSideEffects>(
    BooksListScreenViewState.LoadingState
) {
    fun initViewModel()  {
    }

    override fun intentHandler(intent: Any) {

    }
}