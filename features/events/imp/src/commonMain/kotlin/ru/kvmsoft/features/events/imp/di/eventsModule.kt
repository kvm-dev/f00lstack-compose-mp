package ru.kvmsoft.features.events.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.imp.data.local.LocalDataSource
import ru.kvmsoft.features.events.imp.data.network.EventsApi
import ru.kvmsoft.features.events.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.events.imp.data.repository.EventsRepository
import ru.kvmsoft.features.events.imp.domain.EventsInnerScreenInteractor
import ru.kvmsoft.features.events.imp.domain.EventsListScreenInteractor
import ru.kvmsoft.features.events.imp.domain.usecase.GetEventsUseCaseImp
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsInnerScreenViewModel
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsListScreenViewModel

val eventsModule = module {
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<EventsApi> { EventsApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<EventsRepository> { EventsRepository(localDataSource = get(), networkDataSource = get()) }
    single<GetEventsUseCase> { GetEventsUseCaseImp(repository = get()) }
    single<EventsListScreenInteractor> { EventsListScreenInteractor() }
    single<EventsInnerScreenInteractor> { EventsInnerScreenInteractor() }
    viewModelOf(::EventsListScreenViewModel)
    viewModelOf(::EventsInnerScreenViewModel)
}