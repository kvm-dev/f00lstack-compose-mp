package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksInnerScreenSideEffects {
    data object OnBackPressed: BooksInnerScreenSideEffects()
    data object OpenChat: BooksInnerScreenSideEffects()
    data object CloseApp: BooksInnerScreenSideEffects()
    data class BuyBook(val url: String): BooksInnerScreenSideEffects()
    data class PartnerLink(val url: String): BooksInnerScreenSideEffects()
}