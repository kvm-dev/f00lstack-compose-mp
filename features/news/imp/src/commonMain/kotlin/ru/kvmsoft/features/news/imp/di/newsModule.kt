package ru.kvmsoft.features.news.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.imp.data.local.LocalDataSource
import ru.kvmsoft.features.news.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.news.imp.data.network.NewsApi
import ru.kvmsoft.features.news.imp.data.repository.NewsRepository
import ru.kvmsoft.features.news.imp.domain.NewsInnerScreenInteractor
import ru.kvmsoft.features.news.imp.domain.NewsListScreenInteractor
import ru.kvmsoft.features.news.imp.domain.usecase.GetNewsUseCaseImp
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsInnerScreenViewModel
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsListScreenViewModel

val newsModule = module {
    single<NewsApi> { NewsApi(client = get()) }
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<NewsRepository> { NewsRepository(networkDataSource = get(), localDataSource = get()) }
    single<GetNewsUseCase> { GetNewsUseCaseImp(repository = get()) }
    single<NewsListScreenInteractor> { NewsListScreenInteractor() }
    single<NewsInnerScreenInteractor> { NewsInnerScreenInteractor() }
    viewModelOf(::NewsListScreenViewModel)
    viewModelOf(::NewsInnerScreenViewModel)
}