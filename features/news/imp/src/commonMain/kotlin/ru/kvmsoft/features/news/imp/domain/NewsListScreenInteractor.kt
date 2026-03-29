package ru.kvmsoft.features.news.imp.domain

import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.NewsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.imp.mapper.Mapper.mapToNewsItems
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenViewState

class NewsListScreenInteractor(
    private val getNewsUseCase: GetNewsUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase
) {
    private suspend fun getNews(fromLocal: Boolean = false) = getNewsUseCase.getNews(fromLocal)

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain): NewsListScreenViewState{
        if(isNetworkAvailable()){
            val newsResult = getNews()
            return if(newsResult.errorMsg.isEmpty()){
                NewsListScreenViewState.SuccessState(
                    isNetworkAvailable = true,
                    lang = lang,
                    newsState = UiState.Success(data = NewsItemState(news = newsResult.mapToNewsItems()))
                )
            } else{
                NewsListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(newsResult.errorMsg))
            }


        }
        else{
            val newsResult = getNews(fromLocal = true)
            return if(newsResult.errorMsg.isEmpty()){
                NewsListScreenViewState.SuccessState(
                    isNetworkAvailable = false,
                    lang = lang,
                    newsState = UiState.Success(data = NewsItemState(news = newsResult.mapToNewsItems()))
                )
            } else{
                NewsListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(newsResult.errorMsg))
            }
        }
    }
}