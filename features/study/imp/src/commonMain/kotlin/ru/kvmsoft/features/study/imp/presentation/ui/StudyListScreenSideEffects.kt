package ru.kvmsoft.features.study.imp.presentation.ui

import kotlin.time.Clock

sealed class StudyListScreenSideEffects {
    data object OnClickBack : StudyListScreenSideEffects()
    data object OpenChat : StudyListScreenSideEffects()

    data object CloseApp : StudyListScreenSideEffects()
    data class OpenWebPartnersLink(val url: String) : StudyListScreenSideEffects()
    data object RefreshScreen : StudyListScreenSideEffects()
}