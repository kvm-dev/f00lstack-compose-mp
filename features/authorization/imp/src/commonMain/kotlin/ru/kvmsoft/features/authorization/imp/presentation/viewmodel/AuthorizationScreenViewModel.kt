package ru.kvmsoft.features.authorization.imp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.authorization.imp.domain.AuthorizationScreenInteractor
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenIntents
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenSideEffects
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class AuthorizationScreenViewModel(
    private val interactor: AuthorizationScreenInteractor
) : BaseViewModel<AuthorizationScreenViewState, AuthorizationScreenSideEffects>(
    AuthorizationScreenViewState.IdleState
) {

    var emailValue by mutableStateOf("")
        private set
    var emailError = mutableStateOf("")

    var emailLoading by mutableStateOf(false)
        private set

    var otpValue by mutableStateOf("")
        private set
    var otpError = mutableStateOf("")
    var otpLoading by mutableStateOf(false)
        private set

    private fun loadData() = orbitIntent {
        emailLoading = true
        otpLoading = true
        val stateOrSideEffect = withContext(Dispatchers.IO) {
            interactor.getStateOrSideEffect(
                lang = getLang(),
                userEmail = emailValue,
                userOtp = otpValue,
                setOtpError = { message ->
                    otpError.value = message
                }
            )
        }

        emailLoading = false
        otpLoading = false

        if (stateOrSideEffect is AuthorizationScreenSideEffects) {
            postSideEffect(AuthorizationScreenSideEffects.NAVIGATE_TO_AUTHORIZED_ZONE)
        } else {
            reduce { stateOrSideEffect as AuthorizationScreenViewState }
        }
    }

    fun getLang(): CurrentLanguageDomain{
        val langState = interactor.langState.value
        return if (langState is ResultState.Success){
            langState.data?: CurrentLanguageDomain.EN
        } else{
            interactor.getCurrentLang()
        }
    }

    suspend fun clearUserData() = interactor.clearUserData()

    fun openChat() = interactor.openChat()

    override fun intentHandler(intent: Any) {
        when (intent) {
            AuthorizationScreenIntents.InitViewModelIntent -> loadData()

            AuthorizationScreenIntents.OpenChatIntent -> orbitIntent {
                postSideEffect(AuthorizationScreenSideEffects.OPEN_CHAT)
            }

            AuthorizationScreenIntents.RestartUiIntent -> orbitIntent {
                reduce { AuthorizationScreenViewState.IntermediateState }
                delay(500L)
                reduce { AuthorizationScreenViewState.IdleState }
            }

            AuthorizationScreenIntents.GoToAuthorizationIntent -> orbitIntent {
                withContext(Dispatchers.IO) {
                    postSideEffect(AuthorizationScreenSideEffects.NAVIGATE_TO_AUTHORIZED_ZONE)
                }
            }

            is AuthorizationScreenIntents.SetEmailIntent -> orbitIntent {
                emailValue = intent.value
                emailLoading = false
                emailError.value = ""

                val result = withContext(Dispatchers.IO) {
                    interactor.validateEmail(email = intent.value, lang = getLang())
                }
                emailError.value = result.first
            }

            is AuthorizationScreenIntents.SetOtpIntent -> orbitIntent {
                otpError.value = ""
                otpLoading = false
                if (intent.value.length <= 4) {
                    otpValue = intent.value
                }
            }

            is AuthorizationScreenIntents.SetEmailErrorIntent -> orbitIntent {
                emailError.value = intent.value
            }

            is AuthorizationScreenIntents.SetOtpErrorIntent -> orbitIntent {
                otpError.value = intent.value
            }
        }
    }
}
