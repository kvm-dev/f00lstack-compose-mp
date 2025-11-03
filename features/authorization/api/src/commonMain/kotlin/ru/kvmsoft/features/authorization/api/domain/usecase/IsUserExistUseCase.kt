package ru.kvmsoft.features.authorization.api.domain.usecase

import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain

interface IsUserExistUseCase {

    suspend fun isUserExist(email:String): IsUserExistDomain

}