package ru.kvmsoft.features.books.imp.presentation.ui

import ru.kvmsoft.base.ui.model.BooksItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class BooksListScreenViewState {
    data object LoadingState: BooksListScreenViewState()
    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): BooksListScreenViewState()
    data class SuccessState(
        val isNetworkAvailable: Boolean,
        val isAsModeEnabled: Boolean,
        val lang: CurrentLanguageDomain,
        val booksState: UiState<BooksItemState>,
        val selectedFilters: List<String>,
        val subscribeText: String,
        val subscribeUrl: String
    ): BooksListScreenViewState()
}