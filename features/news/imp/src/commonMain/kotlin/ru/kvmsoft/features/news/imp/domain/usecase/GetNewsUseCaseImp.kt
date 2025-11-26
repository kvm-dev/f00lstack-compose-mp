package ru.kvmsoft.features.news.imp.domain.usecase

import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.api.model.NewsDomain
import ru.kvmsoft.features.news.imp.data.repository.NewsRepository

class GetNewsUseCaseImp(private val repository: NewsRepository): GetNewsUseCase {

    override suspend fun getNews(fromLocal:Boolean): NewsDomain {
        return if(fromLocal){
            repository.getNewsFromLocal()
        }
        else{
            repository.getNewsFromServer()
        }
    }
}