package ru.kvmsoft.features.books.imp.data.network

import ru.kvmsoft.features.books.api.model.BookDomain
import ru.kvmsoft.features.books.api.model.BooksDomain
import ru.kvmsoft.features.books.imp.mapper.Mapper
import ru.kvmsoft.features.books.imp.model.BooksVersionResponse

class NetworkDataSource(private val api: BooksApi){

    suspend fun getBooks(): BooksDomain {
        val result = api.getBooks()
        val bookList = ArrayList<BookDomain>()
        result.books.forEach {book->
            bookList.add(Mapper.map(book))
        }

        return BooksDomain(
            books = bookList,
            maxSalePercent = result.maxSalePercent,
            prText = result.prText,
            subscribeText = result.subscribeText,
            subscribeMinCost = result.subscribeMinCost,
            subscribeLink = result.subscribeLink,
            errorMsg = result.errorMsg
        )
    }

    suspend fun getVersion(): BooksVersionResponse {
        return api.getVersion()
    }
}