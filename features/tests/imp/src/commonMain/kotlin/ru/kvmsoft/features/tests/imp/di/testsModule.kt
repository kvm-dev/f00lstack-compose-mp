package ru.kvmsoft.features.tests.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.tests.api.domain.usecase.CheckOfflineTestResultForIosUseCase
import ru.kvmsoft.features.tests.api.domain.usecase.GetPassedTestsUseCase
import ru.kvmsoft.features.tests.api.domain.usecase.GetTestsUseCase
import ru.kvmsoft.features.tests.api.domain.usecase.SendTestResultUseCase
import ru.kvmsoft.features.tests.imp.data.local.LocalDataSource
import ru.kvmsoft.features.tests.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.tests.imp.data.network.TestsApi
import ru.kvmsoft.features.tests.imp.domain.TestInnerScreenInteractor
import ru.kvmsoft.features.tests.imp.domain.TestsListScreenInteractor
import ru.kvmsoft.features.tests.imp.domain.usecase.CheckOfflineTestResultForIosUseCaseImp
import ru.kvmsoft.features.tests.imp.domain.usecase.GetPassedTestsUseCaseImp
import ru.kvmsoft.features.tests.imp.domain.usecase.GetTestsUseCaseImp
import ru.kvmsoft.features.tests.imp.domain.usecase.SendTestResultUseCaseImp
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestInnerScreenViewModel
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestsListScreenViewModel

val testsModule = module {
    single<TestsApi> { TestsApi(client = get()) }
    single<LocalDataSource> { LocalDataSource(databaseSdk = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<CheckOfflineTestResultForIosUseCase> { CheckOfflineTestResultForIosUseCaseImp(repository = get()) }
    single<GetPassedTestsUseCase> { GetPassedTestsUseCaseImp(repository = get()) }
    single<GetTestsUseCase> { GetTestsUseCaseImp(repository = get()) }
    single<SendTestResultUseCase> { SendTestResultUseCaseImp(repository = get()) }
    single<TestsListScreenInteractor> { TestsListScreenInteractor() }
    single<TestInnerScreenInteractor> { TestInnerScreenInteractor() }
    viewModelOf(::TestsListScreenViewModel)
    viewModelOf(::TestInnerScreenViewModel)
}