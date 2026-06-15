package ru.kvmsoft.features.study.imp.presentation.ui

sealed class StudyListScreenIntents {
    data object InitViewModelIntent : StudyListScreenIntents()

    data object OpenChatIntent : StudyListScreenIntents()

    data object OnClickBack : StudyListScreenIntents()

    data object CloseApplication : StudyListScreenIntents()

    data class UpdateFiltersIntent(val subName: String) : StudyListScreenIntents()
    data class NavigateToPartnersWebIntent(val url: String) : StudyListScreenIntents()

    data object RefreshIntent : StudyListScreenIntents()
}