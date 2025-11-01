package ru.kvmsoft.base.storage.datastore

import kotlinx.coroutines.flow.Flow

expect class EncryptedDataStore {

    val accessToken: Flow<String>
    val refreshToken: Flow<String>
    val professionId: Flow<Int>
    suspend fun saveToken(userToken: String)
    suspend fun saveRefreshToken(refreshToken: String)
    suspend fun saveProfessionId(professionId:Int)
    suspend fun clearUserData()
}