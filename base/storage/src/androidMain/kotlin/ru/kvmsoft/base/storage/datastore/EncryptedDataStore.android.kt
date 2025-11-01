package ru.kvmsoft.base.storage.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

actual class EncryptedDataStore(private val context: Context, private val secureEncryptor: SecureEncryptor) {
    val accessTokenKey = stringPreferencesKey("access_token")
    val refreshTokenKey = stringPreferencesKey("refresh_token")
    val professionIdKey = stringPreferencesKey("profession_id")

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "encryptedData")

    actual val accessToken: Flow<String> =
        context.dataStore.data.map { preferences ->
            val encryptedData = preferences[accessTokenKey] ?: ""
            if(encryptedData.isNotEmpty()){
                secureEncryptor.decrypt(encryptedData)
            }else{
                ""
            }
        }

    actual val refreshToken: Flow<String>  =
        context.dataStore.data.map { preferences ->
            val encryptedData = preferences[refreshTokenKey] ?: ""
            if(encryptedData.isNotEmpty()){
                secureEncryptor.decrypt(encryptedData)
            }else{
                ""
            }
        }

    actual val professionId: Flow<Int>  =
        context.dataStore.data.map { preferences ->
            val encryptedData = preferences[professionIdKey] ?: 0
            if(encryptedData!=0){
                secureEncryptor.decrypt(encryptedData.toString()).toInt()
            }else{
                0
            }
        }

    actual suspend fun saveToken(userToken: String) {
        context.dataStore.edit { preferences ->
            preferences[accessTokenKey] = secureEncryptor.encrypt(userToken)
        }
    }

    actual suspend fun saveRefreshToken(refreshToken: String) {
        context.dataStore.edit { preferences ->
            preferences[refreshTokenKey] = secureEncryptor.encrypt(refreshToken)
        }
    }

    actual suspend fun saveProfessionId(professionId: Int) {
        context.dataStore.edit { preferences ->
            preferences[professionIdKey] = secureEncryptor.encrypt(professionId.toString())
        }
    }

    actual suspend fun clearUserData() {
        context.dataStore.edit {
            it.clear()
        }
    }
}