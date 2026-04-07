package ru.kvmsoft.features.news.imp.presentation.ui

import ru.kvmsoft.base.ui.model.NewsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class NewsListScreenViewState {

    data object LoadingState: NewsListScreenViewState()

    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): NewsListScreenViewState()

    data class SuccessState(
        val isNetworkAvailable: Boolean,
        val lang: CurrentLanguageDomain,
        val newsState: UiState<NewsItemState>,
    ): NewsListScreenViewState()
}