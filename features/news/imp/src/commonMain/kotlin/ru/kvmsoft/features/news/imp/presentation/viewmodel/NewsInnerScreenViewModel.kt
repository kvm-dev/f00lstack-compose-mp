package ru.kvmsoft.features.news.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.news.imp.domain.NewsInnerScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreenViewState

class NewsInnerScreenViewModel(private val interactor: NewsInnerScreenInteractor) : BaseViewModel<NewsInnerScreenViewState, NewsInnerScreenSideEffects>(
    NewsInnerScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}