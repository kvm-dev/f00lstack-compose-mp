package ru.kvmsoft.features.main.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.main.imp.domain.MainScreenInteractor
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel

val mainModule = module {
    single<MainScreenInteractor> { MainScreenInteractor() }
    viewModelOf(::MainScreenViewModel)
}