package ru.kvmsoft.features.books.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.books.imp.domain.BooksInnerScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenIntents
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenSideEffects
import ru.kvmsoft.features.books.imp.presentation.ui.BooksInnerScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class BooksInnerScreenViewModel(private val interactor: BooksInnerScreenInteractor) : BaseViewModel<BooksInnerScreenViewState, BooksInnerScreenSideEffects>(
    BooksInnerScreenViewState.IdleState
) {

    fun openLinkOrOpenChat(url: String = "", isChat: Boolean = false) {
        interactor.buyBookOrOpenChat(url = url, isChat)
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            is BooksInnerScreenIntents.BuyBookIntent -> orbitIntent {
                postSideEffect(BooksInnerScreenSideEffects.BuyBook(intent.url))
            }
            BooksInnerScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(BooksInnerScreenSideEffects.OpenChat)
            }
            BooksInnerScreenIntents.BackPressedIntent -> orbitIntent {
                postSideEffect(BooksInnerScreenSideEffects.OnBackPressed)
            }
            BooksInnerScreenIntents.CloseApplication -> orbitIntent {
                postSideEffect(BooksInnerScreenSideEffects.CloseApp)
            }
            is BooksInnerScreenIntents.PartnerLinkIntent -> orbitIntent {
                postSideEffect(BooksInnerScreenSideEffects.PartnerLink(url = intent.url))
            }

            is BooksInnerScreenIntents.InitViewModelIntent -> orbitIntent {
                val currentState = interactor.checkState(lang = getLang(), bookId = intent.bookId)
                reduce { currentState }
            }
        }
    }
}
