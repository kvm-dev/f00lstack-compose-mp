package ru.kvmsoft.features.main.imp.domain

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.ui.model.AchievementsItemState
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.ui.res.strings.getEmptyName
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.main.imp.mapper.Mapper.mapToAchievementsItems
import ru.kvmsoft.features.main.imp.mapper.Mapper.mapToEventsItems
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreenViewState
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.profile.api.model.ProfileDomain

class MainScreenInteractor(
    private val getProfileUseCase: GetProfileUseCase,
    private val encryptedDataStore: EncryptedDataStore,
    private val getEventsUseCase: GetEventsUseCase,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val getAsModeUseCase: GetAsModeUseCase,
    private val browserUtils: BrowserUtils
) {

    val langState = getCurrentLanguageUseCase.langState

    val profile = getProfileUseCase.profileState

    val isKnowHowToUseEventSlider = encryptedDataStore.mainEventsSlider

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()

    suspend fun isAsModeIsEnabled(isConnectionAvailable: Boolean) = getAsModeUseCase.isAsModeEnabled(isConnectionAvailable)

    suspend fun getProfile(fromLocal: Boolean = false) = getProfileUseCase.getProfile(fromLocal)

    suspend fun clearUserData() =  encryptedDataStore.clearUserData()

    suspend fun getEvents(fromLocal: Boolean = false) = getEventsUseCase.getEvents()

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain, profileDomain: ProfileDomain?, isKnowHowToUseSlider: Boolean): MainScreenViewState{
        val connectionState = isNetworkAvailable()
        val isAsModeEnabled = isAsModeIsEnabled(connectionState).isAsModeActive
        var profile: ProfileDomain?
        if(isNetworkAvailable()){
            val profileResult = getProfile()
            if(profileResult.errorMsg.isEmpty()){
                val eventsResult = getEvents()
                return if(eventsResult.errorMsg.isEmpty()){
                    MainScreenViewState.SuccessState(
                        isNetworkAvailable = false,
                        lang = lang,
                        userName = profileResult.userName.ifEmpty { getEmptyName(lang) },
                        achievements = if(profileResult.userAchievements.isNotEmpty()) {UiState.Success(AchievementsItemState(achievements = profileResult.userAchievements.mapToAchievementsItems()))} else { UiState.Empty},
                        eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                        isAsModeEnabled = isAsModeEnabled,
                        isKnowHowToUseSlider = isKnowHowToUseSlider
                    )
                } else{
                    MainScreenViewState.ErrorState(error = errorsMsgHandler(eventsResult.errorMsg))
                }
            }
            else{
                return MainScreenViewState.ErrorState(error = errorsMsgHandler(profileResult.errorMsg))
            }
        }
        else{
            profile = profileDomain
            if(profile?.userEmail?.isEmpty() == true || profile == null){
                profile = getProfile(fromLocal = true)
                if(profile.userEmail.isEmpty()){
                    return MainScreenViewState.ErrorState(BaseErrors.UNAUTHORIZED)
                }
                else{
                    val eventsResult = getEvents(fromLocal = true)
                    return if(eventsResult.errorMsg.isEmpty()){
                        MainScreenViewState.SuccessState(
                            isNetworkAvailable = false,
                            lang = lang,
                            userName = profile.userName.ifEmpty { getEmptyName(lang) },
                            achievements = if(profile.userAchievements.isNotEmpty()) {UiState.Success(AchievementsItemState(achievements = profile.userAchievements.mapToAchievementsItems()))} else { UiState.Empty},
                            eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                            isAsModeEnabled = isAsModeEnabled,
                            isKnowHowToUseSlider = isKnowHowToUseSlider
                        )
                    } else{
                        MainScreenViewState.ErrorState(error = errorsMsgHandler(errorMsg = eventsResult.errorMsg))
                    }
                }
            }
            else{
                val eventsResult = getEvents(fromLocal = true)
                return if(eventsResult.errorMsg.isEmpty()){
                    MainScreenViewState.SuccessState(
                        isNetworkAvailable = false,
                        lang = lang,
                        userName = profile.userName.ifEmpty { getEmptyName(lang) },
                        achievements = if(profile.userAchievements.isNotEmpty()) {UiState.Success(AchievementsItemState(achievements = profile.userAchievements.mapToAchievementsItems()))} else { UiState.Empty},
                        eventsState = UiState.Success(data = EventsItemState(events = eventsResult.events.mapToEventsItems())),
                        isAsModeEnabled = isAsModeEnabled,
                        isKnowHowToUseSlider = isKnowHowToUseSlider
                    )
                } else{
                    MainScreenViewState.ErrorState(error = errorsMsgHandler(errorMsg = eventsResult.errorMsg))
                }
            }
        }
    }

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }

    suspend fun updateEventsSliderHintState(){
        encryptedDataStore.iKnowHowToUseMainEventsSlider()
    }
}