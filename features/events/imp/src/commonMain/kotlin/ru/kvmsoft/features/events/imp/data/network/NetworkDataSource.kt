package ru.kvmsoft.features.events.imp.data.network

import ru.kvmsoft.features.events.api.model.EventDomain
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.mapper.Mapper
import ru.kvmsoft.features.events.imp.model.EventsVersionResponse

class NetworkDataSource(private val api: EventsApi){

    suspend fun getEvents(): EventsDomain {
        val response = api.getEvents()
        val eventsList = ArrayList<EventDomain>()
        response.events.forEach { event->
            eventsList.add(Mapper.map(event))
        }
        return EventsDomain(
            events = eventsList,
            errorMsg = response.errorMsg
        )
    }

    suspend fun getVersion(): EventsVersionResponse {
        return api.getVersion()
    }
}