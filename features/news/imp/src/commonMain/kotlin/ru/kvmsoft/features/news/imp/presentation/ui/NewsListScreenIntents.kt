package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsListScreenIntents {
    data object InitViewModelIntent : NewsListScreenIntents()
    data object OpenChatIntent: NewsListScreenIntents()

    data class ShareNewsIntent(val url: String): NewsListScreenIntents()
}