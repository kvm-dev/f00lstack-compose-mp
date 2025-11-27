package ru.kvmsoft.features.professions.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.professions.api.model.ProfessionsDomain
import ru.kvmsoft.features.professions.imp.mapper.Mapper

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getProfessions(): ProfessionsDomain {
        return Mapper.mapProfessions(databaseSdk.getProfessions().professions)
    }
    suspend fun saveProfessions(professions:ProfessionsDomain) = databaseSdk.saveProfessions(Mapper.mapToProfessions(professions))

    suspend fun getProfessionId(): Int{
        return databaseSdk.getCurrentProfession()
    }

    suspend fun updateProfessionId(professionId: Int){
        databaseSdk.updateCurrentProfession(professionId)
    }

}