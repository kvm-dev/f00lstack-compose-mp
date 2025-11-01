package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsInnerScreenViewState {

    data object LoadingState: NewsInnerScreenViewState()

    data class ErrorState(val errorMsg: String): NewsInnerScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): NewsInnerScreenViewState()
}