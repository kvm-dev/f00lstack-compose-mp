package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksListScreenViewState {

    data object LoadingState: BooksListScreenViewState()

    data class ErrorState(val errorMsg: String): BooksListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): BooksListScreenViewState()
}