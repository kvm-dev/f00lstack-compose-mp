package ru.kvmsoft.features.news.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.news.imp.domain.NewsListScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenIntents
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenViewState

class NewsListScreenViewModel(private val interactor: NewsListScreenInteractor) : BaseViewModel<NewsListScreenViewState, NewsListScreenSideEffects>(
    NewsListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel(withLoading: Boolean = false) = orbitIntent {
        scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            if(withLoading){
                reduce { NewsListScreenViewState.LoadingState }
                delay(3000)
            }
            currentLangState.collect {
                val currentState = interactor.checkState(
                    lang = it
                )
                reduce { currentState }
            }
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            is NewsListScreenIntents.InitViewModelIntent -> initViewModel(intent.withLoading)

            is NewsListScreenIntents.NavigateToNewsDetailsIntent -> orbitIntent {
                postSideEffect(NewsListScreenSideEffects.NAVIGATE_TO_NEWS_INNER_SCREEN)
            }
            NewsListScreenIntents.OpenChatIntent -> orbitIntent { interactor.openChat() }

            NewsListScreenIntents.RefreshIntent ->  orbitIntent {
                postSideEffect(NewsListScreenSideEffects.REFRESH_SCREEN)
            }
        }
    }
}