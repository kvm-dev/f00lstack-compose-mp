package ru.kvmsoft.features.asmode.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.asmode.imp.data.local.LocalDataSource
import ru.kvmsoft.features.asmode.imp.data.network.AsModeApi
import ru.kvmsoft.features.asmode.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.asmode.imp.data.repository.AsModeRepository
import ru.kvmsoft.features.asmode.imp.domain.usecase.GetAsModeUseCaseImp

val asModeModule = module {
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<AsModeApi> { AsModeApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<AsModeRepository> { AsModeRepository(localDataSource = get(), networkDataSource = get()) }
    single<GetAsModeUseCase> { GetAsModeUseCaseImp(repository = get()) }
}