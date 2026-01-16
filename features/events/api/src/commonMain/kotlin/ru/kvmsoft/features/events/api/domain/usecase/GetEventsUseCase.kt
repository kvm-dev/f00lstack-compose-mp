package ru.kvmsoft.features.events.api.domain.usecase

import ru.kvmsoft.features.events.api.model.EventsDomain

interface GetEventsUseCase {
    suspend fun getEvents(fromLocal: Boolean = false): EventsDomain
}