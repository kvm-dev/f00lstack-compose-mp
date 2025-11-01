package ru.kvmsoft.features.interview.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.interview.imp.domain.InterviewInnerScreenInteractor
import ru.kvmsoft.features.interview.imp.domain.InterviewListScreenInteractor
import ru.kvmsoft.features.interview.imp.presentation.viewmodel.InterviewInnerScreenViewModel
import ru.kvmsoft.features.interview.imp.presentation.viewmodel.InterviewListScreenViewModel

val interviewModule = module {
    single<InterviewListScreenInteractor> { InterviewListScreenInteractor() }
    single<InterviewInnerScreenInteractor> { InterviewInnerScreenInteractor() }
    viewModelOf(::InterviewListScreenViewModel)
    viewModelOf(::InterviewInnerScreenViewModel)
}