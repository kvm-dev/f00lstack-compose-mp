package ru.kvmsoft.features.books.api.domain.usecase

import ru.kvmsoft.features.books.api.model.BooksDomain

interface GetBooksUseCase {

    suspend fun getBooks(fromLocal: Boolean = false): BooksDomain
}