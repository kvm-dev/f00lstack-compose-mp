package ru.kvmsoft.features.news.imp.domain

import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.ShareUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.news.api.domain.usecase.GetNewsUseCase
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenViewState

class NewsInnerScreenInteractor(
    private val getNewsUseCase: GetNewsUseCase,
    private val browserUtils: BrowserUtils,
    private val shareUtils: ShareUtils,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase
) {

    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()

    private suspend fun getNews(fromLocal: Boolean = false) = getNewsUseCase.getNews(fromLocal = fromLocal)

    suspend fun checkState(lang: CurrentLanguageDomain, newsId: Int): NewsInnerScreenViewState {
        val news = getNews(fromLocal = true)

        return if (news.errorMsg.isEmpty()) {
            val newsSingle = news.news.find { it.newsId == newsId }
            if (newsSingle != null) {
                NewsInnerScreenViewState.SuccessState(lang = lang, news = newsSingle)
            } else {
                NewsInnerScreenViewState.ErrorState(lang = lang, error = BaseErrors.UNKNOWN_ERROR)
            }
        } else {
            NewsInnerScreenViewState.ErrorState(
                lang = lang,
                error = errorsMsgHandler(news.errorMsg)
            )
        }
    }

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }

    fun shareNews(url: String){
        shareUtils.shareLink(url)
    }
}