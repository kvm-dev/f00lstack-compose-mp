package ru.kvmsoft.base.storage.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.kvmsoft.base.storage.data.drivers.DatabaseDriverFactory
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.storage.datastore.SecureEncryptor

actual val storagePlatformModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory(context = androidContext()) }
    single<SecureEncryptor> { SecureEncryptor(context = androidContext()) }
    single<EncryptedDataStore> { EncryptedDataStore(context = androidContext(), secureEncryptor = get()) }
}