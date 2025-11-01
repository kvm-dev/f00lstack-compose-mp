package ru.kvmsoft.features.authorization.imp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.kvmsoft.base.ui.utils.EmailTextFieldValidation
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.authorization.imp.domain.AuthorizationScreenInteractor
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorEmailEmpty
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorEmailIncorrect
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreenViewState

class AuthorizationScreenViewModel(private val interactor: AuthorizationScreenInteractor) : BaseViewModel() {
    private val _uiState = MutableStateFlow<AuthorizationScreenViewState>(
        AuthorizationScreenViewState.LoadingState
    )

    var emailValue by mutableStateOf("")
        private set
    var emailError by mutableStateOf("")
        private set
    var emailLoading by mutableStateOf(false)
        private set

    var otpValue by mutableStateOf("")
        private set
    var otpError by mutableStateOf("Something Error")
        private set
    var otpLoading by mutableStateOf(false)
        private set

    val uiState: StateFlow<AuthorizationScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
        if(progressState.value == ProgressState.LOADING){
            launch(Dispatchers.IO) {
//                interactor.userState.collect { userState->
//                    _uiState.update { interactor.getCurrentState(state = userState, currentPosition = currentPosition) }
            }
        }
        getAccessToken()
        saveAccessToken("something token")
        getProfessionId()
        saveProfessionId(23)
        launch {
            isConnectionAvailable()
        }
    }

    private fun validateEmail(): Boolean {
        val lang = currentLangState.value
        val email = emailValue.trim()
        var isValid = true
        var errorMessage = ""
        if (email.isBlank() || email.isEmpty()) {
            errorMessage =
                getAuthorizationErrorEmailEmpty(lang = lang)
            isValid = false
        } else if (!EmailTextFieldValidation.validateEmail(email)) {
            errorMessage =
                getAuthorizationErrorEmailIncorrect(lang = lang)
            isValid = false
        }
        emailError = errorMessage
        return isValid
    }

    fun setEmail(value: String) {
        emailValue = value
        emailLoading = false
        emailError = ""
        validateEmail()
    }

    fun setOtp(value: String) {
        otpError = ""
        otpLoading = false
        if (value.length <= 4) {
            otpValue = value
        }
    }

    fun saveAccessToken(userToken: String) = with(viewModelScope){
        launch(Dispatchers.IO) {
            interactor.saveUserToken(userToken = userToken)
        }
    }

    fun getAccessToken() = with(viewModelScope){
        launch(Dispatchers.IO) {
            interactor.accessToken.collect { userToken->
                println("userToken is $userToken")
            }
        }
    }

    fun saveProfessionId(professionId: Int) = with(viewModelScope){
        launch { interactor.saveProfessionId(professionId) }
    }

    fun getProfessionId() = with(viewModelScope){
        launch(Dispatchers.IO) {
            interactor.professionId.collect { professionId->
                println("professionId is $professionId")
            }
        }
    }
    private suspend fun isConnectionAvailable(){
        val isConnected = interactor.isConnectionAvailable()
    }
}
