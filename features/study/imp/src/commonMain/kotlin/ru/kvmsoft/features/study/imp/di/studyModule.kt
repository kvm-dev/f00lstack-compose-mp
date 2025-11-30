package ru.kvmsoft.features.study.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.study.api.domain.usecase.GetStudiesUseCase
import ru.kvmsoft.features.study.imp.data.local.LocalDataSource
import ru.kvmsoft.features.study.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.study.imp.data.network.StudyApi
import ru.kvmsoft.features.study.imp.data.repository.StudyRepository
import ru.kvmsoft.features.study.imp.domain.StudyListScreenInteractor
import ru.kvmsoft.features.study.imp.domain.usecase.GetStudiesUseCaseImp
import ru.kvmsoft.features.study.imp.presentation.viewmodel.StudyListViewModel

val studyModule = module {

    single<StudyApi> { StudyApi(client = get()) }
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<StudyRepository> { StudyRepository(networkDataSource = get(), localDataSource = get()) }
    single<GetStudiesUseCase> { GetStudiesUseCaseImp(repository = get()) }
    single<StudyListScreenInteractor> { StudyListScreenInteractor() }
    viewModelOf(::StudyListViewModel)
}