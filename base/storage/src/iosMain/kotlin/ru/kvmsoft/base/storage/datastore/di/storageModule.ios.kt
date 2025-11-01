package ru.kvmsoft.base.storage.datastore.di

import org.koin.dsl.module
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore

actual val storageModule = module {
    single<EncryptedDataStore> { EncryptedDataStore() }
}