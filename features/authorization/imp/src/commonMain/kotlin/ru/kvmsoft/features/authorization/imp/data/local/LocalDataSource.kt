package ru.kvmsoft.features.authorization.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.base.storage.model.OfflineAuthData
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class LocalDataSource(private val encryptedDataStore: EncryptedDataStore, private val dataBaseSDK: DataBaseSDK) {

    suspend fun saveUserTokenToLocal(userToken: String){
        encryptedDataStore.saveToken(userToken)
    }

    suspend fun saveRefreshTokenToLocal(refreshToken: String){
        encryptedDataStore.saveRefreshToken(refreshToken)
    }

    @OptIn(ExperimentalTime::class)
    suspend fun saveOfflineAuthData(){
        val currentTime = (Clock.System.now().toEpochMilliseconds()) / 1000
        dataBaseSDK.saveOfflineAuthData(OfflineAuthData(currentTime))

    }

    @OptIn(ExperimentalTime::class)
    suspend fun clearOfflineAuthData(){
        dataBaseSDK.clearOfflineAuthData()

    }

    suspend fun checkOfflineAuthData() = dataBaseSDK.getOfflineAuthData()

}