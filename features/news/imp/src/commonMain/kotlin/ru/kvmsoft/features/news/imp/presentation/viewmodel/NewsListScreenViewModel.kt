package ru.kvmsoft.features.news.imp.presentation.viewmodel

import kotlinx.coroutines.delay
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.news.imp.domain.NewsListScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenIntents
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenViewState

class NewsListScreenViewModel(private val interactor: NewsListScreenInteractor) :
    BaseViewModel<NewsListScreenViewState, NewsListScreenSideEffects>(NewsListScreenViewState.LoadingState) {

    init {
        intentHandler(NewsListScreenIntents.InitViewModelIntent(withLoading = false))
    }

    fun initViewModel(withLoading: Boolean = false) = orbitIntent {
        if (withLoading) {
            reduce { NewsListScreenViewState.LoadingState }
            delay(3000)
        }

        val currentState = interactor.getOrCheckState(lang = getLang())
        reduce { currentState }
    }

    fun openChat() {
        interactor.openChat()
    }

    fun getLang(): CurrentLanguageDomain {
        val langState = interactor.langState.value
        return if (langState is ResultState.Success) {
            langState.data ?: CurrentLanguageDomain.EN
        } else {
            interactor.getCurrentLang()
        }
    }

    override fun intentHandler(intent: Any) {
        when (intent) {
            is NewsListScreenIntents.InitViewModelIntent -> initViewModel(intent.withLoading)

            is NewsListScreenIntents.NavigateToNewsDetailsIntent -> orbitIntent {
                postSideEffect(NewsListScreenSideEffects.NAVIGATE_TO_NEWS_INNER_SCREEN)
            }
            NewsListScreenIntents.OpenChatIntent -> orbitIntent { postSideEffect(NewsListScreenSideEffects.OPEN_CHAT) }
            NewsListScreenIntents.CloseApplication -> orbitIntent { postSideEffect(NewsListScreenSideEffects.CLOSE_APP) }

            NewsListScreenIntents.RefreshIntent -> orbitIntent {
                interactor.clearCache()
                reduce { NewsListScreenViewState.LoadingState }
                postSideEffect(NewsListScreenSideEffects.REFRESH_SCREEN)
                val currentState = interactor.checkState(lang = getLang())
                reduce { currentState }
            }
        }
    }
}