package ru.kvmsoft.features.books.imp.domain

import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.books.api.domain.usecase.GetBooksUseCase
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenViewState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class BooksInnerScreenInteractor(
    private val getBooksUseCase: GetBooksUseCase,
    private val browserUtils: BrowserUtils,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase
) {
    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()

    private suspend fun getBooks(fromLocal: Boolean = false) = getBooksUseCase.getBooks(fromLocal = fromLocal)

    suspend fun checkState(lang: CurrentLanguageDomain, bookId: Int): BooksInnerScreenViewState {
        val books = getBooks(fromLocal = true)
        if (books.errorMsg.isEmpty()) {
            val book = books.books.find { it.bookId == bookId }
            return if (book != null) {
                BooksInnerScreenViewState.SuccessState(
                    lang = lang,
                    book = book,
                    partnerText = books.prText,
                    partnerLink = books.subscribeLink,
                    discountPercent = books.maxSalePercent)
            } else {
                BooksInnerScreenViewState.ErrorState(lang = lang, error = BaseErrors.UNKNOWN_ERROR)
            }
        } else {
            return BooksInnerScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(""))
        }
    }

    fun buyBookOrOpenChat(url: String = "", isChat: Boolean = false){
        if(url.isEmpty() && isChat){
            browserUtils.openInBrowser(getChatLink())
        }
        else{
            browserUtils.openInBrowser(url)
        }
    }
}