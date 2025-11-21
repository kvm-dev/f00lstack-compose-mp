package ru.kvmsoft.features.books.imp.domain.usecase

import ru.kvmsoft.features.books.api.domain.usecase.GetBooksUseCase
import ru.kvmsoft.features.books.api.model.BooksDomain
import ru.kvmsoft.features.books.imp.data.repository.BooksRepository

class GetBooksUseCaseImp(private val repository: BooksRepository): GetBooksUseCase {

    override suspend fun getBooks(fromLocal:Boolean): BooksDomain {
        return if(fromLocal){
            repository.getBooksFromLocal()
        }
        else{
            repository.getBooksFromServer()
        }
    }
}