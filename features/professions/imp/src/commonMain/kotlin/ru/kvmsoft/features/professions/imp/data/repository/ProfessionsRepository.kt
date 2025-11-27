package ru.kvmsoft.features.professions.imp.data.repository

import ru.kvmsoft.features.professions.api.model.ProfessionsDomain
import ru.kvmsoft.features.professions.imp.data.local.LocalDataSource
import ru.kvmsoft.features.professions.imp.data.network.NetworkDataSource

class ProfessionsRepository(private val networkDataSource: NetworkDataSource, private val localDataSource: LocalDataSource) {

    suspend fun getProfessionsFromServer(): ProfessionsDomain {
        val response = networkDataSource.getProfessions()
        return if(response.errorMsg.isEmpty()){
            localDataSource.saveProfessions(response)
            localDataSource.getProfessions()
        }
        else response
    }

    suspend fun getProfessionsFromLocal():ProfessionsDomain{
        return localDataSource.getProfessions()
    }

    suspend fun getProfessionId() = localDataSource.getProfessionId()

    suspend fun saveProfessionId(professionId: Int) = localDataSource.updateProfessionId(professionId)
}