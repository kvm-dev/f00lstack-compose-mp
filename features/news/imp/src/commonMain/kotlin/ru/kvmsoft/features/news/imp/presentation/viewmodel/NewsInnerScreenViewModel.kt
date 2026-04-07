package ru.kvmsoft.features.news.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.news.imp.domain.NewsInnerScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenIntents
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenViewState

class NewsInnerScreenViewModel(private val interactor: NewsInnerScreenInteractor) : BaseViewModel<NewsInnerScreenViewState, NewsInnerScreenSideEffects>(
    NewsInnerScreenViewState.IdleState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    override fun intentHandler(intent: Any) {
        when(intent){
            is NewsInnerScreenIntents.ShareNewsIntent -> orbitIntent {
                val url = (state as NewsInnerScreenViewState.SuccessState).news.newsLink
                interactor.shareNews(url = url)
            }
            NewsInnerScreenIntents.BackPressedIntent -> orbitIntent {
                postSideEffect(NewsInnerScreenSideEffects.ON_BACK_PRESSED)
            }
            NewsInnerScreenIntents.OpenChatIntent -> orbitIntent { interactor.openChat() }

            is NewsInnerScreenIntents.InitViewModelIntent -> orbitIntent {
                scope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                    val currentState = interactor.checkState(lang = currentLangState.value, newsId = intent.newsId)
                    reduce { currentState }
                }
            }
        }
    }
}