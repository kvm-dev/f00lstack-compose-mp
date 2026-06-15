package ru.kvmsoft.features.news.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.news.imp.domain.NewsInnerScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenIntents
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenViewState

class NewsInnerScreenViewModel(private val interactor: NewsInnerScreenInteractor) : BaseViewModel<NewsInnerScreenViewState, NewsInnerScreenSideEffects>(
    NewsInnerScreenViewState.IdleState
) {
    fun shareNews(url: String) = orbitIntent{
        interactor.shareNews(url)
    }

    fun openChat() {
        interactor.openChat()
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            is NewsInnerScreenIntents.ShareNewsIntent -> orbitIntent {
                val url = (state as NewsInnerScreenViewState.SuccessState).news.newsLink
                postSideEffect(NewsInnerScreenSideEffects.ShareNews(url))
            }
            is NewsInnerScreenIntents.CloseApplication -> orbitIntent {
                postSideEffect(NewsInnerScreenSideEffects.CloseApp)
            }
            NewsInnerScreenIntents.BackPressedIntent -> orbitIntent {
                postSideEffect(NewsInnerScreenSideEffects.OnBackPressed)
            }
            NewsInnerScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(NewsInnerScreenSideEffects.OpenChat)
            }

            is NewsInnerScreenIntents.InitViewModelIntent -> orbitIntent {
                    val currentState = interactor.checkState(lang = getLang(), newsId = intent.newsId)
                    reduce { currentState }
            }
        }
    }
}