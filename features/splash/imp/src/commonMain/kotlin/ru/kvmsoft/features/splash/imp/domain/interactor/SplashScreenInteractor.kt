package ru.kvmsoft.features.splash.imp.domain.interactor

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenOfflineLogUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.CheckOfflineAuthDataLogForIosUseCase
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.profile.api.model.ProfileDomain

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
        if(connection){
            checkOfflineAuthDataLogForIosUseCase.checkIosAuthDataLog()
        }
        return connection

    }

    suspend fun authByToken() = authByTokenUserCase.auth()
    suspend fun authByTokenOffline() = authByTokenOfflineLogUseCase.logOfflineAuthBytToken()

    suspend fun clearUserData(){
        encryptedDataStore.clearUserData()
    }
}