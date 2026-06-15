package ru.kvmsoft.base.network.di

import org.koin.dsl.module
import ru.kvmsoft.base.network.HttpClientProvider

val networkModule = module {
    single { HttpClientProvider.client }
}