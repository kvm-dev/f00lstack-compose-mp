package ru.kvmsoft.features.news.imp.domain

import ru.kvmsoft.base.ui.model.NewsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.imp.mapper.Mapper.mapToNewsItems
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenViewState

class NewsListScreenInteractor(
    private val getNewsUseCase: GetNewsUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val browserUtils: BrowserUtils,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase
) {
    private var cachedNewsState: NewsListScreenViewState? = null
    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()
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

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }

    suspend fun getOrCheckState(lang: CurrentLanguageDomain): NewsListScreenViewState {
        if (cachedNewsState is NewsListScreenViewState.SuccessState) {
            return cachedNewsState!!
        }

        val newState = checkState(lang)
        if (newState is NewsListScreenViewState.SuccessState) {
            cachedNewsState = newState
        }
        return newState
    }

    fun clearCache() {
        cachedNewsState = null
    }
}