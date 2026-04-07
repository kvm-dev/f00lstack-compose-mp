package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsInnerScreenIntents {
    data class InitViewModelIntent(val newsId: Int) : NewsInnerScreenIntents()
    data object ShareNewsIntent : NewsInnerScreenIntents()

    data object BackPressedIntent : NewsInnerScreenIntents()
    data object OpenChatIntent : NewsInnerScreenIntents()
}