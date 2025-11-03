package ru.kvmsoft.features.authorization.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.authorization.api.domain.usecase.AuthByEmailUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.ConfirmAuthAndRegUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.IsUserExistUseCase
import ru.kvmsoft.features.authorization.api.domain.usecase.RegistrationByEmailUseCase
import ru.kvmsoft.features.authorization.imp.data.datasource.local.LocalDataSource
import ru.kvmsoft.features.authorization.imp.data.datasource.network.AuthorizationApi
import ru.kvmsoft.features.authorization.imp.data.datasource.network.NetworkDataSource
import ru.kvmsoft.features.authorization.imp.domain.AuthorizationScreenInteractor
import ru.kvmsoft.features.authorization.imp.domain.usecase.AuthByEmailUseCaseImp
import ru.kvmsoft.features.authorization.imp.domain.usecase.ConfirmAuthAndRegUseCaseImp
import ru.kvmsoft.features.authorization.imp.domain.usecase.IsUserExistUseCaseImp
import ru.kvmsoft.features.authorization.imp.domain.usecase.RegistrationByEmailUseCaseImp
import ru.kvmsoft.features.authorization.imp.presentation.viewmodel.AuthorizationScreenViewModel

val authorizationModule = module {
    single<AuthorizationApi> { AuthorizationApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<LocalDataSource> { LocalDataSource(encryptedDataStore = get(), dataBaseSDK = get()) }
    single<AuthByEmailUseCase> { AuthByEmailUseCaseImp(repository = get()) }
    single<ConfirmAuthAndRegUseCase> { ConfirmAuthAndRegUseCaseImp(repository = get()) }
    single<IsUserExistUseCase> { IsUserExistUseCaseImp(repository = get()) }
    single<RegistrationByEmailUseCase> { RegistrationByEmailUseCaseImp(repository = get()) }
    single<AuthorizationScreenInteractor> { AuthorizationScreenInteractor(
        networkStateUseCase = get(),
        confirmAuthAndRegUseCase = get(),
        isUserExistUseCase = get(),
        registrationByEmailUseCase = get(),
        browserUtils = get(),
        authByEmailUseCase = get()) }
    viewModelOf(::AuthorizationScreenViewModel)
}