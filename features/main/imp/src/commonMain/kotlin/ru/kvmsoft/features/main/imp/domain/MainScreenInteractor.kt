package ru.kvmsoft.features.main.imp.domain

import ru.kvmsoft.base.storage.datastore.EncryptedDataStore
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase

class MainScreenInteractor(private val getProfileUseCase: GetProfileUseCase, private val encryptedDataStore: EncryptedDataStore) {
    suspend fun getProfile() = getProfileUseCase.getProfile()

    suspend fun clearUserData(){
        encryptedDataStore.clearUserData()
    }
}