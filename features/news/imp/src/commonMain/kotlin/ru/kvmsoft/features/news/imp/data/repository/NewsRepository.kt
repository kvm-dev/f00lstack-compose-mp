package ru.kvmsoft.features.news.imp.data.repository

import ru.kvmsoft.features.news.api.model.NewsDomain
import ru.kvmsoft.features.news.imp.data.local.LocalDataSource
import ru.kvmsoft.features.news.imp.data.network.NetworkDataSource

class NewsRepository(private val networkDataSource: NetworkDataSource, private val localDataSource: LocalDataSource) {
    suspend fun getNewsFromServer(): NewsDomain {
        val currentVersion = localDataSource.getNewsVersion()
        val serverVersion = networkDataSource.getVersion().version
        return if(currentVersion != serverVersion){
            val result = networkDataSource.getNews()
            if(result.errorMsg.isNotEmpty()){
                result
            }
            else{
                localDataSource.updateNewsVersion(serverVersion)
                localDataSource.saveNews(result)
                localDataSource.getNews()
            }
        } else{
            localDataSource.getNews()
        }
    }

    suspend fun getNewsFromLocal(): NewsDomain = localDataSource.getNews()
}