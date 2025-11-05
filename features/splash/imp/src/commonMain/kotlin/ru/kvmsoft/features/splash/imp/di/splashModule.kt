package ru.kvmsoft.features.splash.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.splash.imp.domain.interactor.SplashScreenInteractor
import ru.kvmsoft.features.splash.imp.presentation.viewmodel.SplashScreenViewModel

val splashModule = module {
    single<SplashScreenInteractor> { SplashScreenInteractor(
        getCurrentLanguageUseCase = get(),
        encryptedDataStore = get(),
        getProfileUseCase = get(),
        authByTokenUserCase = get(),
        networkStateUseCase = get()
    ) }
    viewModelOf(::SplashScreenViewModel)
}