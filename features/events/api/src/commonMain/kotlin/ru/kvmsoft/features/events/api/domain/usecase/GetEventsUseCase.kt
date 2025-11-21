package ru.kvmsoft.features.events.api.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.events.api.model.EventsDomain

interface GetEventsUseCase {

    val eventsState: StateFlow<ResultState<EventsDomain>>
    suspend fun getEvents(fromLocal: Boolean = false): EventsDomain
}