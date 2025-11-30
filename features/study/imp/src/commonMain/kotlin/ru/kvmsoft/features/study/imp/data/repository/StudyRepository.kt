package ru.kvmsoft.features.study.imp.data.repository

import ru.kvmsoft.features.study.api.model.StudiesDomain
import ru.kvmsoft.features.study.imp.data.local.LocalDataSource
import ru.kvmsoft.features.study.imp.data.network.NetworkDataSource

class StudyRepository(private val networkDataSource: NetworkDataSource, private val localDataSource: LocalDataSource) {
    suspend fun getStudiesFromServer(): StudiesDomain {
        val currentVersion = localDataSource.getStudiesVersion()
        val serverVersion = networkDataSource.getVersion().version
        if(currentVersion != serverVersion){

            val result = networkDataSource.getStudies()
            return if(result.errorMsg.isNotEmpty()){
                return result
            }
            else{
                localDataSource.updateStudiesVersion(serverVersion)
                localDataSource.saveStudies(result)
                localDataSource.getStudies()
            }
        }
        else{
            return localDataSource.getStudies()
        }
    }

    suspend fun getStudiesFromLocal():StudiesDomain = localDataSource.getStudies()
}