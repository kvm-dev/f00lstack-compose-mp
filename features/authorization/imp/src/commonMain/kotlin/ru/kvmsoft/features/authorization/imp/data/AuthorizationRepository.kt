package ru.kvmsoft.features.authorization.imp.data

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain
import ru.kvmsoft.features.authorization.imp.data.datasource.local.LocalDataSource
import ru.kvmsoft.features.authorization.imp.data.datasource.network.NetworkDataSource

expect class AuthorizationRepository{

     suspend fun authByEmail(email: String, code:String): AuthByEmailDomain

    suspend fun authByToken(): AuthByTokenDomain

    suspend fun confirmAuthAndReg(email: String, code: String): ConfirmAuthAndRegDomain

    suspend fun isUserExist(email: String): IsUserExistDomain

    suspend fun authByTokenOfflineLog()

    suspend fun registrationByEmail(email: String): RegistrationByEmailDomain

    suspend fun checkAuthOfflineLogDataForIos()
}