package ru.kvmsoft.features.asmode.imp.data.repository

import ru.kvmsoft.features.asmode.api.model.AsModeDomain
import ru.kvmsoft.features.asmode.imp.data.local.LocalDataSource
import ru.kvmsoft.features.asmode.imp.data.network.NetworkDataSource

class AsModeRepository(private val networkDataSource: NetworkDataSource, private val localDataSource: LocalDataSource) {
    suspend fun isAsEnabled(isConnectionAvailable: Boolean): AsModeDomain {
        return if(!isConnectionAvailable){
            AsModeDomain(localDataSource.isAsEnabled())
        } else{
            if(localDataSource.isAsEnabled()){
                return AsModeDomain(localDataSource.isAsEnabled())
            }
            else{
                networkDataSource.getAsModeStatus()
            }
        }
    }
}