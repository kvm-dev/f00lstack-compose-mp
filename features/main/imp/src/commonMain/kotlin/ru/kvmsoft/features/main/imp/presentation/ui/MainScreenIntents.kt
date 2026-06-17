package ru.kvmsoft.features.main.imp.presentation.ui

sealed class MainScreenIntents {
    data object InitViewModelIntent : MainScreenIntents()
    data object OpenChatIntent : MainScreenIntents()
    data object GoToAuthorizationIntent : MainScreenIntents()
    data object NavigateToEventDetailsIntent: MainScreenIntents()
    data object NavigateToEventsList: MainScreenIntents()
    data object NavigateToBooksList: MainScreenIntents()
    data object NavigateToStudyList: MainScreenIntents()
    data object UpdateEventsSliderHintStateIntent: MainScreenIntents()
    data object RefreshIntent: MainScreenIntents()
    data object CloseApplication : MainScreenIntents()

}