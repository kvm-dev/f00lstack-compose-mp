package ru.kvmsoft.features.events.imp.presentation.ui

import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.events.api.model.EventDomain
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

sealed class EventsInnerScreenViewState {

    data object IdleState: EventsInnerScreenViewState()

    data class ErrorState(val lang: CurrentLanguageDomain, val error: BaseErrors?): EventsInnerScreenViewState()

    data class SuccessState(
        val lang: CurrentLanguageDomain,
        val event: EventDomain
    ): EventsInnerScreenViewState()
}