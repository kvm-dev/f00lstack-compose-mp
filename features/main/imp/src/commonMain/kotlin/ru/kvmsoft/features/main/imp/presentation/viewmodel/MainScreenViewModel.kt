package ru.kvmsoft.features.main.imp.presentation.viewmodel

import kotlinx.coroutines.flow.first
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.domain.MainScreenInteractor
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenIntents
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenSideEffects
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenViewState
import ru.kvmsoft.features.profile.api.model.ProfileDomain

class MainScreenViewModel(private val interactor: MainScreenInteractor) :
    BaseViewModel<MainScreenViewState, MainScreenSideEffects>(MainScreenViewState.LoadingState) {

    init {
        intentHandler(MainScreenIntents.InitViewModelIntent)
    }

    fun initViewModel() = orbitIntent {
        val profile = getProfile()
        if (profile != null) {
            val boolState = interactor.isKnowHowToUseEventSlider.first()

            val newState = interactor.getOrCheckState(
                lang = getLang(),
                profileDomain = profile,
                isKnowHowToUseSlider = boolState
            )
            reduce { newState }
        } else {
            interactor.clearUserData()
            postSideEffect(MainScreenSideEffects.NAVIGATE_TO_AUTHORIZATION_ZONE)
        }
    }

    suspend fun getProfile(): ProfileDomain? {
        val profile = interactor.profile.value
        return if (profile is ResultState.Success) {
            profile.data
        } else {
            interactor.getProfile(fromLocal = !interactor.isNetworkAvailable())
        }
    }

    fun getLang(): CurrentLanguageDomain {
        val langState = interactor.langState.value
        return if (langState is ResultState.Success) {
            langState.data ?: CurrentLanguageDomain.EN
        } else {
            interactor.getCurrentLang()
        }
    }

    fun openChat() = interactor.openChat()

    override fun intentHandler(intent: Any) {
        when (intent) {
            MainScreenIntents.GoToAuthorizationIntent -> orbitIntent {
                interactor.clearUserData()
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_AUTHORIZATION_ZONE)
            }

            MainScreenIntents.InitViewModelIntent -> initViewModel()

            MainScreenIntents.UpdateEventsSliderHintStateIntent -> orbitIntent {
                interactor.updateEventsSliderHintState()
            }

            MainScreenIntents.NavigateToEventsList -> orbitIntent {
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_EVENTS_LIST_SCREEN)
            }

            MainScreenIntents.NavigateToBooksList -> orbitIntent {
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_BOOKS_LIST_SCREEN)
            }

            MainScreenIntents.NavigateToStudyList -> orbitIntent {
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_STUDY_LIST_SCREEN)
            }

            MainScreenIntents.CloseApplication -> orbitIntent {
                postSideEffect(MainScreenSideEffects.CLOSE_APP)
            }

            MainScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(MainScreenSideEffects.OPEN_CHAT)
            }

            MainScreenIntents.RefreshIntent -> orbitIntent {
                interactor.clearCache()
                reduce { MainScreenViewState.LoadingState }
                initViewModel()
            }

            is MainScreenIntents.NavigateToEventDetailsIntent -> orbitIntent {
                postSideEffect(MainScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN)
            }
        }
    }
}