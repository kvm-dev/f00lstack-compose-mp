package ru.kvmsoft.features.asmode.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK

class LocalDataSource(private val databaseSdk: DataBaseSDK) {
    suspend fun isAsEnabled(): Boolean {
        return databaseSdk.getProfile().userEmail == "test@foolstack.ru"

    }
}