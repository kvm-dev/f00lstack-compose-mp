package ru.kvmsoft.base.storage.datastore.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.storage.datastore.SecureEncryptor

actual val storageModule = module {
    single<SecureEncryptor> { SecureEncryptor(context = androidContext()) }
    single<EncryptedDataStore> { EncryptedDataStore(context = androidContext(), secureEncryptor = get()) }
}