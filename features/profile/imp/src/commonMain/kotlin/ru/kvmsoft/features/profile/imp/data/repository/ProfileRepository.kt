package ru.kvmsoft.features.profile.imp.data.repository

import ru.kvmsoft.features.profile.api.model.DeleteProfileResponseDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.profile.api.model.UpdateEmailResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdateNameResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdatePhotoResponseDomain
import ru.kvmsoft.features.profile.imp.data.local.LocalDataSource
import ru.kvmsoft.features.profile.imp.data.network.NetworkDataSource as AuthorizationNetworkDataSource
import ru.kvmsoft.base.storage.data.local.LocalDataSource as AuthorizationLocalDataSource

class ProfileRepository(private val localDataSource: LocalDataSource,
                        private val networkDataSource: AuthorizationNetworkDataSource,
                        private val authorizationLocalDataSource: AuthorizationLocalDataSource,
                        private val authorizationNetworkDataSource: AuthorizationNetworkDataSource) {

    suspend fun getProfileFromServer(): ProfileDomain {
        val result = networkDataSource.getProfile()
        return if(result.errorMsg.isEmpty()){
            localDataSource.saveProfile(result)
            localDataSource.getProfile()
        } else{
            result
        }
    }

    suspend fun getProfileFromLocal():ProfileDomain{
        return localDataSource.getProfile()
    }

    suspend fun updateEmail(email: String): UpdateEmailResponseDomain {
        return networkDataSource.updateEmail(email = email)
    }

    suspend fun updateName(name: String): UpdateNameResponseDomain {
        return networkDataSource.updateName(name = name)
    }

    suspend fun updatePhoto(photo: ByteArray): UpdatePhotoResponseDomain {
        return networkDataSource.updatePhoto(photo = photo)
    }

    suspend fun deleteProfile(): DeleteProfileResponseDomain {
        val result =  networkDataSource.deleteProfile()
        localDataSource.logout()
        return result
    }

    suspend fun logout(){
        localDataSource.logout()
        localDataSource.getProfile()
    }
}