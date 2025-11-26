package ru.kvmsoft.features.news.imp.data.network

import ru.kvmsoft.features.news.api.model.NewsDomain
import ru.kvmsoft.features.news.api.model.SingleNewsDomain
import ru.kvmsoft.features.news.imp.mapper.Mapper
import ru.kvmsoft.features.news.imp.model.NewsVersionResponse

class NetworkDataSource(private val api: NewsApi){

    suspend fun getNews(): NewsDomain {
        val response = api.getNews()
        val newsList = ArrayList<SingleNewsDomain>()
        response.news.forEach { new->
            newsList.add(Mapper.map(new))
        }
        return NewsDomain(
            news = newsList,
            errorMsg = response.errorMsg
        )
    }

    suspend fun getVersion(): NewsVersionResponse {
        return api.getVersion()
    }
}