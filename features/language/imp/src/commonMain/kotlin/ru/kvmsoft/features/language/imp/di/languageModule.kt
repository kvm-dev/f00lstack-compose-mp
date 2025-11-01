package ru.kvmsoft.features.language.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.imp.data.LanguageRepository
import ru.kvmsoft.features.language.imp.data.datasource.DataSource
import ru.kvmsoft.features.language.imp.domain.usecase.GetCurrentLanguageUseCaseImp

val languageModule = module {
    single<DataSource> { DataSource (helper = get()) }
    single<LanguageRepository> { LanguageRepository(dataSource = get()) }
    single<GetCurrentLanguageUseCase> { GetCurrentLanguageUseCaseImp(repository = get()) }
}