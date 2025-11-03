package ru.kvmsoft.base.storage.di

import org.koin.dsl.module
import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.base.storage.data.local.LocalDataSource

val storageModule = module {
    single<LocalDataSource> { LocalDataSource(databaseDriverFactory = get()) }
    single<DataBaseSDK> { DataBaseSDK(dataSource = get()) }
}