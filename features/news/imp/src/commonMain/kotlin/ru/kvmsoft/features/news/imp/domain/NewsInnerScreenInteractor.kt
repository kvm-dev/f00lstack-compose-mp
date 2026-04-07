package ru.kvmsoft.features.news.imp.domain

import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.ShareUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenViewState

class NewsInnerScreenInteractor(
    private val getNewsUseCase: GetNewsUseCase,
    private val browserUtils: BrowserUtils,
    private val shareUtils: ShareUtils
) {
    private suspend fun getNews(fromLocal: Boolean = false) = getNewsUseCase.getNews(fromLocal = fromLocal)

    suspend fun checkState(lang: CurrentLanguageDomain, newsId: Int): NewsInnerScreenViewState{
        val news = getNews(fromLocal = true)
        if(news.errorMsg.isEmpty()){
            val newsSingle = news.news.find { it.newsId == newsId }
            return if(newsSingle!=null){
                NewsInnerScreenViewState.SuccessState(lang = lang, news = newsSingle)
            } else{
                NewsInnerScreenViewState.ErrorState(lang = lang, error = BaseErrors.UNKNOWN_ERROR)
            }
        }
        else{
            return NewsInnerScreenViewState.ErrorState(lang = lang, error(errorsMsgHandler(news.errorMsg)))
        }

    }

    fun openEventUrl(url: String){
        browserUtils.openInBrowser(url)
    }

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }

    fun shareNews(url: String){
        shareUtils.shareLink(url)
    }
}