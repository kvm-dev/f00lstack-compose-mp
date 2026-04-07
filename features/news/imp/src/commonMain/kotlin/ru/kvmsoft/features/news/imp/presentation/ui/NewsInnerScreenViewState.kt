package ru.kvmsoft.features.news.imp.presentation.ui

import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.news.api.model.SingleNewsDomain

sealed class NewsInnerScreenViewState {

    data object IdleState: NewsInnerScreenViewState()

    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): NewsInnerScreenViewState()

    data class SuccessState(
        val lang: CurrentLanguageDomain,
        val news: SingleNewsDomain
    ): NewsInnerScreenViewState()
}