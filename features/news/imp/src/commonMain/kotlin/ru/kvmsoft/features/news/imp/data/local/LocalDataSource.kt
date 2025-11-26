package ru.kvmsoft.features.news.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.features.news.api.model.NewsDomain
import ru.kvmsoft.features.news.imp.mapper.Mapper


class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun getNews(): NewsDomain = Mapper.map(databaseSdk.getNews())
    suspend fun saveNews(news:NewsDomain) = databaseSdk.saveNews(Mapper.map(news))
    suspend fun getNewsVersion(): Int  = databaseSdk.getNewsVersion()
    suspend fun updateNewsVersion(version: Int) = databaseSdk.updateNewsVersion(version)
}