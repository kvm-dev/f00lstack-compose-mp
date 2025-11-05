package ru.kvmsoft.features.profile.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.profile.imp.mapper.Mapper

class LocalDataSource(
    private val databaseSdk: DataBaseSDK,
    val encryptedDataStore: EncryptedDataStore) {

    suspend fun getProfile(): ProfileDomain {
        val profile = databaseSdk.getProfile()
        return Mapper.mapToProfileDomain(profile = profile)
    }
    suspend fun saveProfile(profile:ProfileDomain){
        databaseSdk.saveProfile(profile = Mapper.mapFromProfileDomain(profile, profile.userPhotoBase64))
    }

    suspend fun logout(){
        databaseSdk.clearProfileAndPassedTests()
        encryptedDataStore.clearUserData()
    }

}