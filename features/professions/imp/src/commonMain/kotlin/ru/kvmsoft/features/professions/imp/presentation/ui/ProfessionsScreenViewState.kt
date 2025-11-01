package ru.kvmsoft.features.professions.imp.presentation.ui

sealed class ProfessionsScreenViewState {

    data object LoadingState: ProfessionsScreenViewState()

    data class ErrorState(val errorMsg: String): ProfessionsScreenViewState()

    data class SuccessState(
        val userData: String,
        val currentPosition: String
    ): ProfessionsScreenViewState()
}