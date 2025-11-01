package ru.kvmsoft.features.settings.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.settings.imp.domain.SettingsScreenInteractor
import ru.kvmsoft.features.settings.imp.presentation.viewmodel.SettingsScreenViewModel

val settingsModule = module {
    single<SettingsScreenInteractor> { SettingsScreenInteractor() }
    viewModelOf(::SettingsScreenViewModel)
}