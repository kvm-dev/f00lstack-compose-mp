package ru.kvmsoft.features.study.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.study.api.model.StudiesDomain
import ru.kvmsoft.features.study.imp.mapper.Mapper

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getStudies(): StudiesDomain = Mapper.map(databaseSdk.getStudies())
    suspend fun saveStudies(studies:StudiesDomain) = databaseSdk.saveStudies(Mapper.map(studies))

    suspend fun getStudiesVersion():Int = databaseSdk.getStudiesVersion()

    suspend fun updateStudiesVersion(version: Int) = databaseSdk.updateStudiesVersion(version)
}