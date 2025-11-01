package ru.kvmsoft.features.events.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.events.imp.domain.EventsInnerScreenInteractor
import ru.kvmsoft.features.events.imp.domain.EventsListScreenInteractor
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsInnerScreenViewModel
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsListScreenViewModel

val eventsModule = module {
    single<EventsListScreenInteractor> { EventsListScreenInteractor() }
    single<EventsInnerScreenInteractor> { EventsInnerScreenInteractor() }
    viewModelOf(::EventsListScreenViewModel)
    viewModelOf(::EventsInnerScreenViewModel)
}