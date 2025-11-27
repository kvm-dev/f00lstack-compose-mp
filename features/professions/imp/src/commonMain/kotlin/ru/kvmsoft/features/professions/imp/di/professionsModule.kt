package ru.kvmsoft.features.professions.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.professions.api.domain.usecase.GetProfessionsUseCase
import ru.kvmsoft.features.professions.imp.data.local.LocalDataSource
import ru.kvmsoft.features.professions.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.professions.imp.data.network.ProfessionsApi
import ru.kvmsoft.features.professions.imp.data.repository.ProfessionsRepository
import ru.kvmsoft.features.professions.imp.domain.ProfessionsScreenInteractor
import ru.kvmsoft.features.professions.imp.domain.usecase.GetProfessionsUseCaseImp
import ru.kvmsoft.features.professions.imp.presentation.viewmodel.ProfessionsScreenViewModel

val professionsModule = module {
    single<ProfessionsApi> { ProfessionsApi(client = get()) }
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<ProfessionsRepository> { ProfessionsRepository(networkDataSource = get(), localDataSource = get()) }
    single<GetProfessionsUseCase> { GetProfessionsUseCaseImp(repository = get()) }


    single<ProfessionsScreenInteractor> { ProfessionsScreenInteractor() }
    viewModelOf(::ProfessionsScreenViewModel)
}