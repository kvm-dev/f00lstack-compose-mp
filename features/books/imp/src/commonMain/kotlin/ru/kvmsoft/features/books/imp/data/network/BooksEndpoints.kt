package ru.kvmsoft.features.books.imp.data.network

object BooksEndpoints {
    val getBooks: String
        get() = "books/get-books/"

    val getBooksVersion: String
        get() = "books/get-version/"
}