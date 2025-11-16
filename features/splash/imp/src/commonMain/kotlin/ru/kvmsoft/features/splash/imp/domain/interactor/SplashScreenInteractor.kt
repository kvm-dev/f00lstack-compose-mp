package ru.kvmsoft.features.splash.imp.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenOfflineLogUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.CheckOfflineAuthDataLogForIosUseCase
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState

class SplashScreenInteractor(
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    private val encryptedDataStore: EncryptedDataStore,
    private val getProfileUseCase: GetProfileUseCase,
    private val authByTokenUserCase: AuthByTokenUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val authByTokenOfflineLogUseCase: AuthByTokenOfflineLogUseCase,
    private val checkOfflineAuthDataLogForIosUseCase: CheckOfflineAuthDataLogForIosUseCase) {

    val userToken = encryptedDataStore.accessToken
    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()

    suspend fun getProfile(): ProfileDomain = getProfileUseCase.getProfile(fromLocal = false)
    suspend fun getProfileFromLocal() = getProfileUseCase.getProfile(fromLocal = true)

    suspend fun isNetworkAvailable(): Boolean{
        val connection = networkStateUseCase.isNetworkAvailable()
        println("канет $connection")
        if(connection){
            checkOfflineAuthDataLogForIosUseCase.checkIosAuthDataLog()
        }
        println("шо рет $connection")
        return connection

    }

    suspend fun authByToken() = authByTokenUserCase.auth()
    suspend fun authByTokenOffline() = authByTokenOfflineLogUseCase.logOfflineAuthBytToken()

     fun defaultViewState(): SplashScreenViewState{
        return SplashScreenViewState(
            language = CurrentLanguageDomain.EN,
            isConnectionAvailable = false,
            userToken = "",
            profile = null
        )
    }

    suspend fun clearUserData(){
        encryptedDataStore.clearUserData()
    }
}