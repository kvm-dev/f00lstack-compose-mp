package ru.kvmsoft.features.books.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.books.api.domain.usecase.GetBooksUseCase
import ru.kvmsoft.features.books.imp.data.local.LocalDataSource
import ru.kvmsoft.features.books.imp.data.network.BooksApi
import ru.kvmsoft.features.books.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.books.imp.data.repository.BooksRepository
import ru.kvmsoft.features.books.imp.domain.BooksInnerScreenInteractor
import ru.kvmsoft.features.books.imp.domain.BooksListScreenInteractor
import ru.kvmsoft.features.books.imp.domain.usecase.GetBooksUseCaseImp
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksInnerScreenViewModel
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksListScreenViewModel

val booksModule = module {

    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<BooksApi> { BooksApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<BooksRepository> { BooksRepository(localDataSource = get(), networkDataSource = get()) }
    single<GetBooksUseCase> { GetBooksUseCaseImp(repository = get()) }
    single<BooksListScreenInteractor> { BooksListScreenInteractor() }
    single<BooksInnerScreenInteractor> { BooksInnerScreenInteractor() }
    viewModelOf(::BooksListScreenViewModel)
    viewModelOf(::BooksInnerScreenViewModel)
}