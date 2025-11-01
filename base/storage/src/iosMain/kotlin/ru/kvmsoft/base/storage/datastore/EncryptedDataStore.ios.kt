package ru.kvmsoft.base.storage.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import platform.Foundation.NSUserDefaults

actual class EncryptedDataStore {

    val ACCESS_TOKEN_KEY = "ACCESS_TOKEN"
    val REFRESH_TOKEN_KEY = "REFRESH_TOKEN"
    val PROFESSION_ID_KEY = "PROFESSION_ID"

    private val userDefaults = NSUserDefaults.standardUserDefaults()

    actual val accessToken: Flow<String>
        get() {
            return flow {
                emit(userDefaults.stringForKey(ACCESS_TOKEN_KEY)?: "")
            }
        }

    actual val refreshToken: Flow<String>
        get() {
            return flow {
                emit(userDefaults.stringForKey(REFRESH_TOKEN_KEY)?: "")
            }
        }
    actual val professionId: Flow<Int>
        get() {
            return flow {
                emit(userDefaults.integerForKey(PROFESSION_ID_KEY).toInt())
            }
        }

    actual suspend fun saveToken(userToken: String) {
        userDefaults.setObject(userToken, forKey = ACCESS_TOKEN_KEY)
    }

    actual suspend fun saveRefreshToken(refreshToken: String) {
        userDefaults.setObject(refreshToken, forKey = REFRESH_TOKEN_KEY)
    }

    actual suspend fun saveProfessionId(professionId: Int) {
        userDefaults.setObject(professionId, forKey = PROFESSION_ID_KEY)
    }

    actual suspend fun clearUserData() {
        userDefaults.removeObjectForKey(ACCESS_TOKEN_KEY)
        userDefaults.removeObjectForKey(REFRESH_TOKEN_KEY)
        userDefaults.removeObjectForKey(PROFESSION_ID_KEY)
        userDefaults.synchronize()
    }

}