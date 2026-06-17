package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksListScreenIntents {
    data object InitViewModelIntent : BooksListScreenIntents()
    data object OnClickBack : BooksListScreenIntents()
    data object OpenChatIntent: BooksListScreenIntents()
    data object CloseApplication : BooksListScreenIntents()
    data object NavigateToBookDetailsIntent: BooksListScreenIntents()
    data object RefreshIntent: BooksListScreenIntents()
    data class UpdateFiltersIntent(val subName: String): BooksListScreenIntents()
    data object BuyBookIntent: BooksListScreenIntents()
    data class SubscribeIntent(val url: String): BooksListScreenIntents()

}