package ru.kvmsoft.features.study.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.study.imp.domain.StudyListScreenInteractor
import ru.kvmsoft.features.study.imp.presentation.viewmodel.StudyListViewModel

val studyModule = module {
    single<StudyListScreenInteractor> { StudyListScreenInteractor() }
    viewModelOf(::StudyListViewModel)
}