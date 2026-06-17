package ru.kvmsoft.features.books.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.books.imp.domain.BooksListScreenInteractor
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenIntents
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenSideEffects
import ru.kvmsoft.features.books.imp.presentation.ui.BooksListScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class BooksListScreenViewModel(private val interactor: BooksListScreenInteractor) : BaseViewModel<BooksListScreenViewState, BooksListScreenSideEffects>(
    BooksListScreenViewState.LoadingState
) {
    fun initViewModel() = orbitIntent {
        reduce { BooksListScreenViewState.LoadingState }
        val currentState = interactor.checkState(lang = getLang())
        reduce { currentState }
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    fun openUrlOrChat(url: String = "", isChat: Boolean = false) {
        interactor.openUrlOrChat(url, isChat)
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            BooksListScreenIntents.InitViewModelIntent -> initViewModel()
            is BooksListScreenIntents.UpdateFiltersIntent -> orbitIntent {
                if(intent.subName.isNotEmpty()){
                    val current = state as BooksListScreenViewState.SuccessState
                    val selectedFilters = HashSet<String>()
                    current.selectedFilters.forEach { sub->
                        selectedFilters.add(sub)
                    }
                    if(selectedFilters.contains(intent.subName)){
                        selectedFilters.remove(intent.subName)
                    }
                    else{
                        selectedFilters.add(intent.subName)
                    }
                    reduce { current.copy(selectedFilters = selectedFilters.toList()) }
                }
            }

            is BooksListScreenIntents.NavigateToBookDetailsIntent -> orbitIntent {
                postSideEffect(BooksListScreenSideEffects.NAVIGATE_TO_BOOK_INNER_SCREEN)
            }
            BooksListScreenIntents.OpenChatIntent -> orbitIntent { postSideEffect(BooksListScreenSideEffects.OPEN_CHAT) }

            BooksListScreenIntents.RefreshIntent ->  orbitIntent {
                postSideEffect(BooksListScreenSideEffects.REFRESH_SCREEN)
            }
            BooksListScreenIntents.OnClickBack ->  orbitIntent {
                postSideEffect(BooksListScreenSideEffects.ON_CLICK_BACK)
            }
            BooksListScreenIntents.CloseApplication ->  orbitIntent {
                postSideEffect(BooksListScreenSideEffects.CLOSE_APP)
            }
            is BooksListScreenIntents.SubscribeIntent-> orbitIntent {
                postSideEffect(BooksListScreenSideEffects.SUBSCRIBE)
            }
            BooksListScreenIntents.BuyBookIntent-> orbitIntent {
                postSideEffect(BooksListScreenSideEffects.BUY_BOOK)
            }
        }
    }
}