package ru.kvmsoft.features.books.imp.presentation.ui

import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.books.api.model.BookDomain
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class BooksInnerScreenViewState {
    data object IdleState: BooksInnerScreenViewState()
    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): BooksInnerScreenViewState()
    data class SuccessState(
        val lang: CurrentLanguageDomain,
        val book: BookDomain,
        val discountPercent: Int,
        val partnerText: String,
        val partnerLink: String
    ): BooksInnerScreenViewState()
}