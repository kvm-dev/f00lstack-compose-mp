package ru.kvmsoft.features.tests.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

actual val testsPlatformModule = module{
    single<TestsRepository> { TestsRepository(localDataSource = get(), networkDataSource = get()) }
}