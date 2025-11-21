package ru.kvmsoft.features.events.imp.data.repository

import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.data.local.LocalDataSource
import ru.kvmsoft.features.events.imp.data.network.NetworkDataSource

class EventsRepository(private val networkDataSource: NetworkDataSource, private val localDataSource: LocalDataSource) {

    suspend fun getEventsFromServer(): EventsDomain {
        val currentVersion = localDataSource.getEventsVersion()
        val serverVersion = networkDataSource.getVersion().version
        return if(currentVersion != serverVersion){
            val response = networkDataSource.getEvents()
            if(response.errorMsg.isNotEmpty()){
                response
            }
            else{
                localDataSource.updateEventsVersion(serverVersion)
                localDataSource.saveEvents(response)
                localDataSource.getEvents()
            }
        } else{
            localDataSource.getEvents()
        }
    }

    suspend fun getEventsFromLocal():EventsDomain = localDataSource.getEvents()
}