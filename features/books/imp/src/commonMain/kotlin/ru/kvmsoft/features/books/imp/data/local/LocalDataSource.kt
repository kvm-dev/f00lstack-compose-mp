package ru.kvmsoft.features.books.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.books.api.model.BookDomain
import ru.kvmsoft.features.books.api.model.BooksDomain
import ru.kvmsoft.features.books.imp.mapper.Mapper

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getBooks(): BooksDomain {
        val books = databaseSdk.getBooks()
        val booksList = arrayListOf<BookDomain>()
        books.books.forEach { book->
            booksList.add(Mapper.map(book))
        }
        return BooksDomain(
            books = booksList,
            maxSalePercent = books.maxSalePercent,
            prText = books.prText,
            subscribeMinCost = books.subscribeMinCost,
            subscribeText = books.subscribeText,
            subscribeLink = books.subscribeLink,
            errorMsg = books.errorMsg
        )
    }
    suspend fun saveBooks(books:BooksDomain){
        databaseSdk.saveBooks(Mapper.map(books))
    }

    suspend fun getBooksVersion():Int = databaseSdk.getBooksVersion()

    suspend fun updateBooksVersion(version: Int) = databaseSdk.updateBooksVersion(version)
}