package ru.kvmsoft.features.books.imp.domain

import ru.kvmsoft.base.ui.model.BooksItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.books.api.domain.usecase.GetBooksUseCase
import ru.kvmsoft.features.books.imp.mapper.Mapper.mapToBooksItems
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenViewState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class BooksListScreenInteractor(
    private val getBooksUseCase: GetBooksUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val getAsModeUseCase: GetAsModeUseCase,
    private val browserUtils: BrowserUtils,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
) {
    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()
    suspend fun isAsModeIsEnabled(isConnectionAvailable: Boolean) = getAsModeUseCase.isAsModeEnabled(isConnectionAvailable)

    private suspend fun getBooks(fromLocal: Boolean = false) = getBooksUseCase.getBooks(fromLocal)

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain): BooksListScreenViewState{
        val connectionState = isNetworkAvailable()
        val isAsModeEnabled = isAsModeIsEnabled(connectionState).isAsModeActive
        if(isNetworkAvailable()){
            val booksResult = getBooks()
            if(booksResult.errorMsg.isEmpty()){
                val filtersList = HashSet<String>()
                booksResult.books.forEach { book->
                    book.professions.forEach { profession->
                        filtersList.add(profession.professionName)
                    }
                }
                return BooksListScreenViewState.SuccessState(
                    isNetworkAvailable = true,
                    isAsModeEnabled = isAsModeEnabled,
                    lang = lang,
                    booksState = UiState.Success(data = BooksItemState(books = booksResult.books.mapToBooksItems())),
                    selectedFilters = filtersList.toList(),
                    subscribeText = booksResult.prText,
                    subscribeUrl = booksResult.subscribeLink
                )
            }
            else{
                return BooksListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(booksResult.errorMsg))
            }
        }
        else{
            val booksResult = getBooks(fromLocal = true)
            if(booksResult.errorMsg.isEmpty()){
                val filtersList = HashSet<String>()
                booksResult.books.forEach { book->
                    book.professions.forEach { profession->
                        filtersList.add(profession.professionName)
                    }
                }
                return BooksListScreenViewState.SuccessState(
                    isNetworkAvailable = false,
                    lang = lang,
                    booksState = UiState.Success(data = BooksItemState(books = booksResult.books.mapToBooksItems())),
                    isAsModeEnabled = isAsModeEnabled,
                    selectedFilters = filtersList.toList(),
                    subscribeText = booksResult.prText,
                    subscribeUrl = booksResult.subscribeLink
                )
            }
            else{
                return BooksListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(booksResult.errorMsg))
            }
        }
    }

    fun openUrlOrChat(url: String, isChat: Boolean){
        if(url.isEmpty() && isChat){
            browserUtils.openInBrowser(getChatLink())
        }
        else{
            browserUtils.openInBrowser(url)
        }
    }
}