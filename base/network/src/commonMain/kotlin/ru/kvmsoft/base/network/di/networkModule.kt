package ru.kvmsoft.base.network.di

import io.ktor.client.HttpClient
import org.koin.dsl.module
import ru.kvmsoft.base.network.client

val networkModule = module {
    single<HttpClient> { client }
}