package ru.kvmsoft.features.main.imp.presentation.ui

sealed class MainScreenIntents {
    data object InitViewModelIntent : MainScreenIntents()
    data object OpenChatIntent : MainScreenIntents()
    data object GoToAuthorizationIntent : MainScreenIntents()
    data object NavigateToEventDetailsIntent: MainScreenIntents()
    data object UpdateEventsSliderHintStateIntent: MainScreenIntents()
}