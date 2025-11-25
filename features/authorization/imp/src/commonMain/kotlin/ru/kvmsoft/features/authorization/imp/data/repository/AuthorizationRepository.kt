package ru.kvmsoft.features.authorization.imp.data.repository

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain

expect class AuthorizationRepository{

     suspend fun authByEmail(email: String, code:String): AuthByEmailDomain

    suspend fun authByToken(): AuthByTokenDomain

    suspend fun confirmAuthAndReg(email: String, code: String): ConfirmAuthAndRegDomain

    suspend fun isUserExist(email: String): IsUserExistDomain

    suspend fun authByTokenOfflineLog()

    suspend fun registrationByEmail(email: String): RegistrationByEmailDomain

    suspend fun checkAuthOfflineLogDataForIos()
}