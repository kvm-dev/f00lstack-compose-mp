package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsListScreenIntents {
    data object InitViewModelIntent : NewsListScreenIntents()

    data object OpenChatIntent : NewsListScreenIntents()
    data object NavigateToNewsDetailsIntent: NewsListScreenIntents()

    data object RefreshIntent: NewsListScreenIntents()
}