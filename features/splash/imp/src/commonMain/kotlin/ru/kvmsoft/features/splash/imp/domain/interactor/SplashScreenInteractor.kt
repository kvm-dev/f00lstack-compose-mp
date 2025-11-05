package ru.kvmsoft.features.splash.imp.domain.interactor

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByTokenUseCase
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreenViewState

class SplashScreenInteractor(
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    encryptedDataStore: EncryptedDataStore,
    private val getProfileUseCase: GetProfileUseCase,
    private val authByTokenUserCase: AuthByTokenUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase) {

    val userToken = encryptedDataStore.accessToken
    val langState = getCurrentLanguageUseCase.langState

     fun getCurrentLang(){
        getCurrentLanguageUseCase.getLang()
    }

    suspend fun getState(langState: ResultState<CurrentLanguageDomain>, withToken: Boolean): SplashScreenViewState{
        return when(langState){
            ResultState.Idle -> {
                SplashScreenViewState.LoadingState
            }
            ResultState.Loading -> {
                SplashScreenViewState.LoadingState
            }
            is ResultState.Success-> {
                SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN)
                if(withToken){
                    if(networkStateUseCase.isNetworkAvailable()){
                        val authByTokenResult = authByTokenUserCase.auth()
                        return if(authByTokenResult.errorMsg.isEmpty()){
                            SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN, isAuthorized =  true)
                        } else{
                            SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN)
                        }
                    }
                    else{
                        return if(getProfileUseCase.getProfile(fromLocal = true).userId>0){
                            SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN, isAuthorized = true)
                        } else{
                            SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN)
                        }
                    }
                }
                else{
                   return SplashScreenViewState.SuccessState(language = langState.data?: CurrentLanguageDomain.EN)
                }
            }
        }
    }
}