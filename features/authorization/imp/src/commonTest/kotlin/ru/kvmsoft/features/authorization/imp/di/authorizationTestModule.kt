package ru.kvmsoft.features.authorization.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.authorization.imp.data.network.TestAuthorizationApi

val authorizationTestModule = module {
    single<TestAuthorizationApi> { TestAuthorizationApi() }
}