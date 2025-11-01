package ru.kvmsoft.features.networkconnection.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.networkconnection.imp.domain.usecase.GetNetworkStateUseCaseImp

val networkConnectionModule = module {
    single<GetNetworkStateUseCase> { GetNetworkStateUseCaseImp() }
}