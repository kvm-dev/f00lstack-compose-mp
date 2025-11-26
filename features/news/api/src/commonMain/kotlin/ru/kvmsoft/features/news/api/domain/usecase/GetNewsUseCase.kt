package ru.kvmsoft.features.news.api.domain.usecase

import ru.kvmsoft.features.news.api.model.NewsDomain

interface GetNewsUseCase {

    suspend fun getNews(fromLocal: Boolean = false): NewsDomain
}