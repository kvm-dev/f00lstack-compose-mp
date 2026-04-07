package ru.kvmsoft.features.events.imp.domain

import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.events.api.domain.usecase.GetEventsUseCase
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreenViewState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

class EventsInnerScreenInteractor(
    private val getEventsUseCase: GetEventsUseCase,
    private val browserUtils: BrowserUtils
) {
    private suspend fun getEvents(fromLocal: Boolean = false) = getEventsUseCase.getEvents(fromLocal = fromLocal)

    suspend fun checkState(lang: CurrentLanguageDomain, eventId: Int): EventsInnerScreenViewState{
        val events = getEvents(fromLocal = true)
        if(events.errorMsg.isEmpty()){
            val event = events.events.find { it.eventId == eventId }
            return if(event!=null){
                EventsInnerScreenViewState.SuccessState(lang = lang, event = event)
            } else{
                EventsInnerScreenViewState.ErrorState(lang = lang, error = BaseErrors.UNKNOWN_ERROR)
            }
        }
        else{
            return EventsInnerScreenViewState.ErrorState(lang = lang, error(errorsMsgHandler("")))
        }
    }

    fun openEventUrl(url: String){
        browserUtils.openInBrowser(url)
    }

    fun openChat(){
        browserUtils.openInBrowser(getChatLink())
    }
}