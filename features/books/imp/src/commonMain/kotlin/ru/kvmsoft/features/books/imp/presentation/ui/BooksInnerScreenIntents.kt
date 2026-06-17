package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksInnerScreenIntents {
    data class InitViewModelIntent(val bookId: Int) : BooksInnerScreenIntents()
    data object BackPressedIntent : BooksInnerScreenIntents()
    data object OpenChatIntent : BooksInnerScreenIntents()
    data object CloseApplication : BooksInnerScreenIntents()
    data class BuyBookIntent(val url: String) : BooksInnerScreenIntents()
    data class PartnerLinkIntent(val url: String) : BooksInnerScreenIntents()
}