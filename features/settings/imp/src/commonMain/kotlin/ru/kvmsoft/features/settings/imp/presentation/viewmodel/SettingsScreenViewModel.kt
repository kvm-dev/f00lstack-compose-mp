package ru.kvmsoft.features.settings.imp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.plus
import ru.kvmsoft.base.viewmodel.BaseViewModel
import ru.kvmsoft.features.settings.imp.domain.SettingsScreenInteractor
import ru.kvmsoft.features.settings.imp.presentation.ui.SettingsScreenSideEffects
import ru.kvmsoft.features.settings.imp.presentation.ui.SettingsScreenViewState

class SettingsScreenViewModel(private val interactor: SettingsScreenInteractor) : BaseViewModel<SettingsScreenViewState, SettingsScreenSideEffects>(
    SettingsScreenViewState.LoadingState
) {
    val scope = (viewModelScope + coroutineExceptionHandler)

    fun initViewModel() = with(viewModelScope + coroutineExceptionHandler) {

    }

    override fun intentHandler(intent: Any) {

    }
}