package ru.kvmsoft.features.authorization.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository

actual val authorizationPlatformModule = module {
    single<AuthorizationRepository> { AuthorizationRepository(localDataSource = get(), networkDataSource = get()) }
}