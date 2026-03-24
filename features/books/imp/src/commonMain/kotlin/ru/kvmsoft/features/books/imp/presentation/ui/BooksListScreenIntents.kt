package ru.kvmsoft.features.books.imp.presentation.ui

sealed class BooksListScreenIntents {
    data object InitViewModelIntent : BooksListScreenIntents()
}