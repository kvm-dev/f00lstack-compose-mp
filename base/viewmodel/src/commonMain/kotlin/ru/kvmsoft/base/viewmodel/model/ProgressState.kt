package ru.kvmsoft.base.viewmodel.model

import ru.kvmsoft.base.utils.model.BaseErrors

sealed class ProgressState {
    object IDLE: ProgressState()
    object LOADING: ProgressState()
    object UNAUTHORIZED: ProgressState()
    data class COMPLETED<T>(val uiState: T): ProgressState()
    data class ERROR(val error: BaseErrors): ProgressState()
}