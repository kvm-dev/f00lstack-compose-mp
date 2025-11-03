package ru.kvmsoft.base.storage.di

import org.koin.dsl.module
import ru.kvmsoft.base.storage.data.drivers.DatabaseDriverFactory
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore

actual val storagePlatformModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory() }
    single<EncryptedDataStore> { EncryptedDataStore() }
}