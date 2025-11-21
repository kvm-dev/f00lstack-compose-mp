package ru.kvmsoft.features.events.imp.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.data.repository.EventsRepository

class GetEventsUseCaseImp(private val repository: EventsRepository):GetEventsUseCase {

    private val _events = MutableStateFlow<ResultState<EventsDomain>>(ResultState.Idle)

    override val eventsState = _events.asStateFlow()
    override suspend fun getEvents(fromLocal: Boolean): EventsDomain {
        _events.tryEmit(ResultState.Loading)
        return if(fromLocal){
            val cachedEvents = repository.getEventsFromLocal()
            _events.tryEmit(ResultState.Success(cachedEvents))
            cachedEvents
        }
        else{
            val responseEvents = repository.getEventsFromServer()
            _events.tryEmit(ResultState.Success(responseEvents))
            responseEvents
        }
    }
}