package ru.kvmsoft.features.events.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.mapper.Mapper

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getEvents(): EventsDomain {
        val result = databaseSdk.getEvents()
        return if (result.errorMsg.isEmpty()) {
            EventsDomain(
                events = Mapper.map(databaseSdk.getEvents().events),
                errorMsg = ""
            )
        } else {
            EventsDomain(
                events = listOf(),
                errorMsg = result.errorMsg
            )
        }
    }
    suspend fun saveEvents(events:EventsDomain){
        try {
            databaseSdk.saveEvents(Mapper.map(events))
        }
        catch (e: Exception){
            throw e
        }
    }

    suspend fun getEventsVersion():Int {
        return try {
            databaseSdk.getEventsVersion()
        } catch (_: Exception){
            0
        }
    }

    suspend fun updateEventsVersion(version: Int){
        try {
            databaseSdk.updateEventsVersion(version)
        }
        catch (e: Exception){
            throw e
        }
    }
}