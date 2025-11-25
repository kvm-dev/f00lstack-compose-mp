package ru.kvmsoft.features.authorization.imp.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository
import ru.kvmsoft.features.authorization.imp.data.network.DelayedAuthByTokenLogger

actual val authorizationPlatformModule = module{
    single<DelayedAuthByTokenLogger> { DelayedAuthByTokenLogger(platformContext = androidContext())}
    single<AuthorizationRepository> { AuthorizationRepository(localDataSource = get(), networkDataSource = get(), delayedAuthByTokenLogger = get()) }
}