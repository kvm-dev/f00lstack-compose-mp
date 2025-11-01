package ru.kvmsoft.features.professions.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.professions.imp.domain.ProfessionsScreenInteractor
import ru.kvmsoft.features.professions.imp.presentation.viewmodel.ProfessionsScreenViewModel

val professionsModule = module {
    single<ProfessionsScreenInteractor> { ProfessionsScreenInteractor() }
    viewModelOf(::ProfessionsScreenViewModel)
}