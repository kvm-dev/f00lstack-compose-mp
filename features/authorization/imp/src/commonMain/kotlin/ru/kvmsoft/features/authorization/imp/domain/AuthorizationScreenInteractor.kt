package ru.kvmsoft.features.authorization.imp.domain

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase

class AuthorizationScreenInteractor(private val networkStateUseCase: GetNetworkStateUseCase, private val encryptedDataStore: EncryptedDataStore) {


    val accessToken = encryptedDataStore.accessToken
    val refreshToken = encryptedDataStore.refreshToken
    val professionId = encryptedDataStore.professionId
    suspend fun isConnectionAvailable(): Boolean{
        return networkStateUseCase.isNetworkAvailable()
    }

    suspend fun saveUserToken(userToken: String){
        encryptedDataStore.saveToken(userToken)
    }

    suspend fun saveRefreshToken(refreshToken: String){
        encryptedDataStore.saveRefreshToken(refreshToken)
    }

    suspend fun saveProfessionId(professionId:Int){
        encryptedDataStore.saveProfessionId(professionId)
    }



}