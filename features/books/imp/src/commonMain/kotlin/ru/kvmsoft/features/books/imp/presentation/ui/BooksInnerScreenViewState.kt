package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksInnerScreenViewState {

    data object LoadingState: BooksInnerScreenViewState()

    data class ErrorState(val errorMsg: String): BooksInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): BooksInnerScreenViewState()
}