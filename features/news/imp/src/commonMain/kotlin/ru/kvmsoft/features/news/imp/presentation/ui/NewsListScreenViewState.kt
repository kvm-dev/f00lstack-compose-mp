package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsListScreenViewState {

    data object LoadingState: NewsListScreenViewState()

    data class ErrorState(val errorMsg: String): NewsListScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): NewsListScreenViewState()
}