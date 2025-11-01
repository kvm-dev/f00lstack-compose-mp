package ru.kvmsoft.features.authorization.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.authorization.imp.domain.AuthorizationScreenInteractor
import ru.kvmsoft.features.authorization.imp.presentation.viewmodel.AuthorizationScreenViewModel

val authorizationModule = module {
    single<AuthorizationScreenInteractor> { AuthorizationScreenInteractor(networkStateUseCase = get(), encryptedDataStore = get()) }
    viewModelOf(::AuthorizationScreenViewModel)
}