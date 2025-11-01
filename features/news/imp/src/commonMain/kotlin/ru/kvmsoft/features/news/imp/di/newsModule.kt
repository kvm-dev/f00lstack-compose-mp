package ru.kvmsoft.features.news.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.news.imp.domain.NewsInnerScreenInteractor
import ru.kvmsoft.features.news.imp.domain.NewsListScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsInnerScreenViewModel
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsListScreenViewModel

val newsModule = module {
    single<NewsListScreenInteractor> { NewsListScreenInteractor() }
    single<NewsInnerScreenInteractor> { NewsInnerScreenInteractor() }
    viewModelOf(::NewsListScreenViewModel)
    viewModelOf(::NewsInnerScreenViewModel)
}