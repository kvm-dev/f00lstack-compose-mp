package ru.kvmsoft.features.authorization.imp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.authorization.imp.domain.AuthorizationScreenInteractor
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenIntents
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenSideEffects
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenViewState

class AuthorizationScreenViewModel(private val interactor: AuthorizationScreenInteractor) : BaseViewModel<AuthorizationScreenViewState, AuthorizationScreenSideEffects>(
    AuthorizationScreenViewState.IdleState){

    val scope = (viewModelScope + coroutineExceptionHandler)

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
        scope.launch(Dispatchers.IO + coroutineExceptionHandler){
            emailLoading = true
            otpLoading = true
            val state = interactor.checkState(
                lang = currentLangState.value,
                userEmail = emailValue,
                userOtp = otpValue,
                setOtpError = { otpError.value = it }
            )
            emailLoading = false
            otpLoading = false
            reduce { state }
        }
    }

    override fun intentHandler(intent: Any) {
        when(intent){
            AuthorizationScreenIntents.InitViewModelIntent -> loadData()
            AuthorizationScreenIntents.OpenChatIntent -> orbitIntent { interactor.openChat() }
            AuthorizationScreenIntents.RestartUiIntent -> orbitIntent { reduce { AuthorizationScreenViewState.IdleState } }
            AuthorizationScreenIntents.GoToAuthorizationIntent -> orbitIntent {
                scope.launch(Dispatchers.IO + coroutineExceptionHandler){
                        interactor.clearUserData()
                }
            }
            is AuthorizationScreenIntents.SetEmailIntent -> orbitIntent {
                emailValue = intent.value
                emailLoading = false
                emailError.value = ""
                val result = interactor.validateEmail(email = intent.value, lang = currentLangState.value)
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
