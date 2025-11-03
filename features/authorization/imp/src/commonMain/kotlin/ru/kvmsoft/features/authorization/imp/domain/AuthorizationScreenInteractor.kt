package ru.kvmsoft.features.authorization.imp.domain

import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.ui.res.strings.getErrorTextCodeIsAlreadySent
import ru.kvmsoft.base.ui.res.strings.getErrorTextCodeIsIncorrect
import ru.kvmsoft.base.ui.res.strings.getErrorTextCodeIsWrongOrExpired
import ru.kvmsoft.base.ui.res.strings.getErrorTextUserIsAlreadyConfirmed
import ru.kvmsoft.base.ui.res.strings.getErrorTextUserIsNotFound
import ru.kvmsoft.base.ui.res.strings.getErrorTextUserIsUnconfirmed
import ru.kvmsoft.base.ui.res.strings.hardCreateUnknownError
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByEmailUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.ConfirmAuthAndRegUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.IsUserExistUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.RegistrationByEmailUseCase
import ru.kvmsoft.features.authorization.api.model.AuthorizationErrors
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorOtpAlreadySent
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorOtpCodeIsEmptyOrIncorrect
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class AuthorizationScreenInteractor(
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val confirmAuthAndRegUseCase: ConfirmAuthAndRegUseCase,
    private val isUserExistUseCase: IsUserExistUseCase,
    private val registrationByEmailUseCase: RegistrationByEmailUseCase,
    private val authByEmailUseCase: AuthByEmailUseCase,
    private val browserUtils: BrowserUtils) {

    suspend fun checkState(
        setOtpError:(String)-> Unit,
        setEmailError:(String)-> Unit,
        lang: CurrentLanguageDomain,
        userEmail: String? = null,
        userOtp: String? = null): AuthorizationScreenViewState{
        val isNetworkAvailable = networkStateUseCase.isNetworkAvailable()
        if(!isNetworkAvailable){
            setOtpError("")
            setEmailError("")
            return AuthorizationScreenViewState.ErrorState(lang = lang, errorsMsgHandler(null))
        }
        else{
            if(!userEmail.isNullOrEmpty()){
                if(userOtp.isNullOrEmpty()){
                    val isUserExistResult = isUserExistUseCase.isUserExist(userEmail)
                    if(isUserExistResult.errorMsg.isEmpty()){
                        if(isUserExistResult.success){
                            setOtpError("")
                            return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(isUserExistResult.errorMsg))
                        }
                        else{
                            val registrationResult = registrationByEmailUseCase.registration(email = userEmail)
                            return if(registrationResult.errorMsg.isEmpty()){
                                if(registrationResult.success){
                                    setOtpError("")
                                    setEmailError("")
                                    AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(registrationResult.errorMsg))
                                } else{
                                    setOtpError("")
                                    setEmailError("")
                                    AuthorizationScreenViewState.ErrorState(lang = lang, errorsMsgHandler(errorMsg = hardCreateUnknownError()))
                                }
                            } else{
                                setEmailError(registrationResult.errorMsg)
                                AuthorizationScreenViewState.AuthorizationRegistrationState(lang = lang, error = errorsMsgHandler(registrationResult.errorMsg))
                            }
                        }
                    }
                    else{
                        val error = errorsMsgHandler(isUserExistResult.errorMsg)
                        when(error){
                            AuthorizationErrors.CODE_IS_ALREADY_SENT -> {
                                setOtpError(getAuthorizationErrorOtpAlreadySent(lang = lang))
                                return AuthorizationScreenViewState.OtpState(lang = lang, error = error)
                            }
                            AuthorizationErrors.USER_IS_UNCONFIRMED -> {
                                setOtpError("")
                                return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                            }
                            AuthorizationErrors.USER_IS_NOT_FOUND -> {
                                registrationByEmailUseCase.registration(email = userEmail)
                                setOtpError("")
                                setEmailError("")
                                return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                            }
                            else -> {
                                setOtpError("")
                                setEmailError("")
                                AuthorizationScreenViewState.ErrorState(lang = lang, error)
                            }
                        }
                    }
                }
                else{
                    val authOrRegResult = confirmAuthAndRegUseCase.confirm(email = userEmail, code = userOtp)
                    return if(authOrRegResult.errorMsg.isNotEmpty()){
                        val error = errorsMsgHandler(authOrRegResult.errorMsg)
                        if(error == AuthorizationErrors.USER_IS_ALREADY_CONFIRMED){
                            val authorizationByEmailResult = authByEmailUseCase.auth(email = userEmail, code = userOtp)
                            setOtpError("")
                            setEmailError("")
                            if(authorizationByEmailResult.errorMsg.isNotEmpty()){
                                val errorAuthorization = errorsMsgHandler(authorizationByEmailResult.errorMsg)
                                if(errorAuthorization == AuthorizationErrors.CODE_IS_INCORRECT){
                                    setOtpError(getAuthorizationErrorOtpCodeIsEmptyOrIncorrect(lang = lang))
                                    return AuthorizationScreenViewState.OtpState(lang = lang, error = error)
                                }
                                if(errorAuthorization == AuthorizationErrors.USER_IS_UNCONFIRMED){
                                    setOtpError("")
                                    return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                                }
                                if(errorAuthorization == AuthorizationErrors.CODE_IS_EXPIRED){
                                    val isCurrentExist = isUserExistUseCase.isUserExist(email = userEmail)
                                    if(isCurrentExist.errorMsg.isNotEmpty()){
                                        val error = errorsMsgHandler(isCurrentExist.errorMsg)
                                        when(error){
                                            AuthorizationErrors.CODE_IS_ALREADY_SENT -> {
                                                setOtpError(getAuthorizationErrorOtpAlreadySent(lang = lang))
                                                return AuthorizationScreenViewState.OtpState(lang = lang, error = error)
                                            }
                                            AuthorizationErrors.USER_IS_UNCONFIRMED -> {
                                                setOtpError("")
                                                return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                                            }
                                            AuthorizationErrors.USER_IS_NOT_FOUND -> {
                                                registrationByEmailUseCase.registration(email = userEmail)
                                                setOtpError("")
                                                return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                                            }
                                            else -> {
                                                setOtpError("")
                                                setEmailError("")
                                                return AuthorizationScreenViewState.ErrorState(lang = lang, error)
                                            }
                                        }
                                    }
                                    else{
                                        setOtpError("")
                                        return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(""))
                                    }
                                }
                            }
                            else{
                                return AuthorizationScreenViewState.AuthorizedState
                            }
                        }
                        if(error == AuthorizationErrors.CODE_IS_INCORRECT){
                            setOtpError(getAuthorizationErrorOtpCodeIsEmptyOrIncorrect(lang = lang))
                            return AuthorizationScreenViewState.OtpState(lang = lang, error = error)
                        }
                        setOtpError(authOrRegResult.errorMsg)
                        return AuthorizationScreenViewState.OtpState(lang = lang, error = errorsMsgHandler(authOrRegResult.errorMsg))
                    } else{
                        if(!authOrRegResult.success){
                            setOtpError("")
                            setEmailError("")
                            AuthorizationScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(hardCreateUnknownError()))
                        } else{
                            setOtpError("")
                            setEmailError("")
                            AuthorizationScreenViewState.AuthorizedState
                        }
                    }
                }
            }
        }
        setEmailError("")
        return AuthorizationScreenViewState.AuthorizationRegistrationState(lang = lang, error = errorsMsgHandler(""))
    }

     fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }
    private fun errorsMsgHandler(errorMsg: String?): AuthorizationErrors? {
        return when (errorMsg) {
            null -> AuthorizationErrors.CONNECTION_NOT_FOUND
            "" -> null
            hardCreateUnknownError()-> AuthorizationErrors.UNKNOWN_ERROR
            getErrorTextUserIsUnconfirmed() -> AuthorizationErrors.USER_IS_UNCONFIRMED
            getErrorTextUserIsNotFound() -> AuthorizationErrors.USER_IS_NOT_FOUND
            getErrorTextCodeIsAlreadySent()-> AuthorizationErrors.CODE_IS_ALREADY_SENT
            getErrorTextUserIsAlreadyConfirmed()-> AuthorizationErrors.USER_IS_ALREADY_CONFIRMED
            getErrorTextCodeIsIncorrect() -> AuthorizationErrors.CODE_IS_INCORRECT
            getErrorTextCodeIsWrongOrExpired()-> AuthorizationErrors.CODE_IS_EXPIRED
            else -> AuthorizationErrors.UNKNOWN_ERROR
        }
    }

}