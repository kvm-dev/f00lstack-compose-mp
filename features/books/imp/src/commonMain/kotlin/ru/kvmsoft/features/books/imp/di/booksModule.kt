package ru.kvmsoft.features.books.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.books.imp.domain.BooksInnerScreenInteractor
import ru.kvmsoft.features.books.imp.domain.BooksListScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksInnerScreenViewModel
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksListScreenViewModel

val booksModule = module {
    single<BooksListScreenInteractor> { BooksListScreenInteractor() }
    single<BooksInnerScreenInteractor> { BooksInnerScreenInteractor() }
    viewModelOf(::BooksListScreenViewModel)
    viewModelOf(::BooksInnerScreenViewModel)
}