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
import kotlinx.coroutines.flow.update
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
        AuthorizationScreenViewState.AuthorizationRegistrationState(lang = currentLangState.value, error = null)
    )

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

    val uiState: StateFlow<AuthorizationScreenViewState> = _uiState.asStateFlow()

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {
            launch(Dispatchers.IO) {
                checkState()
                updateState(ProgressState.COMPLETED)
            }
    }

    fun checkState() = with(viewModelScope + coroutineExceptionHandler) {
        launch(Dispatchers.IO) {
            emailLoading = true
            otpLoading = true
            val state = interactor.checkState(lang = currentLangState.value, userEmail = emailValue, userOtp = otpValue, setOtpError = ::setOtpError)
            emailLoading = false
            otpLoading = false
            _uiState.update { state }
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
        emailError.value = errorMessage
        return isValid
    }

    fun setEmail(value: String) {
        emailValue = value
        emailLoading = false
        emailError.value = ""
        validateEmail()
    }

    fun setOtp(value: String) {
        otpError.value = ""
        otpLoading = false
        if (value.length <= 4) {
            otpValue = value
        }
    }

    fun openChat(){
        interactor.openChat()
    }

    fun restartUIState(){
        _uiState.update { AuthorizationScreenViewState.LoadingState }
        initViewModel()
    }

    fun restartProgressState(){
        updateState(ProgressState.LOADING)
    }

    fun setIdleProgressState(){
        updateState(ProgressState.IDLE)
    }

    fun setEmailError(errorText: String){
        emailError.value = errorText
    }
    fun setOtpError(errorText: String){
        otpError.value = errorText
    }

}
