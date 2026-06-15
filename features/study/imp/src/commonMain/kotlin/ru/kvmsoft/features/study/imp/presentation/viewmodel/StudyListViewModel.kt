package ru.kvmsoft.features.study.imp.presentation.viewmodel

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.study.imp.domain.StudyListScreenInteractor
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenIntents
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenSideEffects
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenViewState

class StudyListViewModel(private val interactor: StudyListScreenInteractor) : BaseViewModel<StudyListScreenViewState, StudyListScreenSideEffects>(
    StudyListScreenViewState.LoadingState
) {

    fun initViewModel() = orbitIntent {
            reduce { StudyListScreenViewState.LoadingState }
                val currentState = interactor.checkState(
                    lang = getLang()
                )
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

    fun openBrowserOrChat(isChat: Boolean = false, url: String = "") {
        interactor.openBrowserOrChat(isChat, url)
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            StudyListScreenIntents.InitViewModelIntent -> initViewModel()
            is StudyListScreenIntents.UpdateFiltersIntent -> orbitIntent {
                if(intent.subName.isNotEmpty() && state is StudyListScreenViewState.SuccessState){
                    val current = state as StudyListScreenViewState.SuccessState
                    val selectedFilters = current.selectedFilters.toMutableSet()

                    if(selectedFilters.contains(intent.subName)){
                        selectedFilters.remove(intent.subName)
                    } else {
                        selectedFilters.add(intent.subName)
                    }
                    reduce { current.copy(selectedFilters = selectedFilters.toList()) }
                }
            }

            StudyListScreenIntents.OnClickBack -> orbitIntent {
                postSideEffect(StudyListScreenSideEffects.OnClickBack)
            }

            is StudyListScreenIntents.NavigateToPartnersWebIntent -> orbitIntent {
                postSideEffect(StudyListScreenSideEffects.OpenWebPartnersLink(intent.url))
            }

            StudyListScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(StudyListScreenSideEffects.OpenChat)
            }

            StudyListScreenIntents.RefreshIntent -> orbitIntent {
                postSideEffect(StudyListScreenSideEffects.RefreshScreen)
            }
        }
    }
}