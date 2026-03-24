package ru.kvmsoft.features.news.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.news.imp.domain.NewsListScreenInteractor
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenSideEffects
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreenViewState

class NewsListScreenViewModel(private val interactor: NewsListScreenInteractor) : BaseViewModel<NewsListScreenViewState, NewsListScreenSideEffects>(
    NewsListScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}