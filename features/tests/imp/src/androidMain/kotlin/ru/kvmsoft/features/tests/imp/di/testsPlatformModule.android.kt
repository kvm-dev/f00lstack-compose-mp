package ru.kvmsoft.features.tests.imp.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.kvmsoft.features.tests.imp.data.network.LocalTestResultSender
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

actual val testsPlatformModule = module{
    single<LocalTestResultSender> { LocalTestResultSender(platformContext = androidContext()) }
    single<TestsRepository> { TestsRepository(localDataSource = get(), networkDataSource = get(), localTestResultSender = get()) }
}