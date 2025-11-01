package ru.kvmsoft.features.profile.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.profile.imp.domain.ProfileScreenInteractor
import ru.kvmsoft.features.profile.imp.presentation.viewmodel.ProfileScreenViewModel

val profileModule = module {
    single<ProfileScreenInteractor> { ProfileScreenInteractor() }
    viewModelOf(::ProfileScreenViewModel)
}