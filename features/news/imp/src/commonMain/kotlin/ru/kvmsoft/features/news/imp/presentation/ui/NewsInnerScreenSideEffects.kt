package ru.kvmsoft.features.news.imp.presentation.ui

sealed class NewsInnerScreenSideEffects{
    data object OnBackPressed: NewsInnerScreenSideEffects()
    data object OpenChat: NewsInnerScreenSideEffects()
    data object CloseApp: NewsInnerScreenSideEffects()
    data class ShareNews(val url: String): NewsInnerScreenSideEffects()
}