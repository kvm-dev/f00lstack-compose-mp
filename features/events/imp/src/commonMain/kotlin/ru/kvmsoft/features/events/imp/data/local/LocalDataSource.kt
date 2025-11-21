package ru.kvmsoft.features.events.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.mapper.Mapper

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getEvents(): EventsDomain {
        return EventsDomain(
            events =  Mapper.map(databaseSdk.getEvents().events),
            errorMsg = ""
        )
    }
    suspend fun saveEvents(events:EventsDomain){
        databaseSdk.saveEvents(Mapper.map(events))
    }

    suspend fun getEventsVersion():Int = databaseSdk.getEventsVersion()

    suspend fun updateEventsVersion(version: Int) = databaseSdk.updateEventsVersion(version)
}