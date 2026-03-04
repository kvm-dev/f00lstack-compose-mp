package ru.kvmsoft.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.Syntax
import ru.kvmsoft.base.network.model.NetworkError
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any>(
    initialState: STATE
) : ContainerHost<STATE, SIDE_EFFECT>, ViewModel() {

    // The container manages the state and side effects
    override val container = viewModelScope.container<STATE, SIDE_EFFECT>(initialState)

    // Helper function to handle intents easily in child classes
    protected fun orbitIntent(
        transform: suspend Syntax<STATE, SIDE_EFFECT>.() -> Unit
    ) = intent {
        transform()
    }

    // You can add other common logic here, like a generic error handler
    protected fun postErrorSideEffect(error: BaseErrors) = intent {
        postSideEffect(error as SIDE_EFFECT) // This assumes SIDE_EFFECT can handle a BASE error
    }

    private val _currentLangState = MutableStateFlow(CurrentLanguageDomain.EN)
    val currentLangState: StateFlow<CurrentLanguageDomain> = _currentLangState.asStateFlow()

    private val _profile = MutableStateFlow<ProfileDomain?>(null)
    val profile: StateFlow<ProfileDomain?> = _profile.asStateFlow()

    fun updateLangState(langState: CurrentLanguageDomain){
        _currentLangState.value = langState
    }

    fun updateProfileState(profile: ProfileDomain?){
        _profile.value = profile
    }

    abstract fun intentHandler(intent: Any)

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when(throwable){
            is NetworkError.BadRequest, is NetworkError.Unauthorized -> {
//                updateState(ProgressState.UNAUTHORIZED)
            }
            else->{
                //todo not know at now
            }
        }
    }

    fun finishApplication() = closeApp()

    val supervisorJob = SupervisorJob()
}