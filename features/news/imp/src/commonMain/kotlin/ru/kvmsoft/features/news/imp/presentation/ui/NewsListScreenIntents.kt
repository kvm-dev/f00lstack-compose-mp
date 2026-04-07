package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsListScreenIntents {
    data class InitViewModelIntent(val withLoading: Boolean = true) : NewsListScreenIntents()

    data object OpenChatIntent : NewsListScreenIntents()
    data object NavigateToNewsDetailsIntent: NewsListScreenIntents()

    data object RefreshIntent: NewsListScreenIntents()
}