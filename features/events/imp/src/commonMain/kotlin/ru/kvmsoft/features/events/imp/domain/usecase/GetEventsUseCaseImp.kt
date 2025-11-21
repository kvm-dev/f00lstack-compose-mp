package ru.kvmsoft.features.events.imp.domain.usecase

import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.data.repository.EventsRepository

class GetEventsUseCaseImp(private val repository: EventsRepository):GetEventsUseCase {

    override suspend fun getEvents(fromLocal: Boolean): EventsDomain {
        return if(fromLocal){
            repository.getEventsFromLocal()
        }
        else{
            repository.getEventsFromServer()
        }
    }
}