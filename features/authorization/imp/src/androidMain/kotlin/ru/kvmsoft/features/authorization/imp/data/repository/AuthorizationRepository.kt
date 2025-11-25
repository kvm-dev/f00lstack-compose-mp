package ru.kvmsoft.features.authorization.imp.data.repository

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain
import ru.kvmsoft.features.authorization.imp.data.local.LocalDataSource
import ru.kvmsoft.features.authorization.imp.data.network.DelayedAuthByTokenLogger
import ru.kvmsoft.features.authorization.imp.data.network.NetworkDataSource

actual class AuthorizationRepository(private val localDataSource: LocalDataSource,
                                     private val networkDataSource: NetworkDataSource,
                                     private val delayedAuthByTokenLogger: DelayedAuthByTokenLogger
) {

    actual suspend fun authByEmail(email: String, code:String): AuthByEmailDomain {
        val result = networkDataSource.authByEmail(email = email, code = code)
        return if(result.errorMsg.isEmpty()){
            localDataSource.saveUserTokenToLocal(userToken = result.userToken)
            localDataSource.saveRefreshTokenToLocal(refreshToken = result.userRefreshToken)
            AuthByEmailDomain(userToken = result.userToken,
                userRefreshToken = result.userRefreshToken,
                errorMsg = "")
        }
        else{
            return result
        }
    }

    actual suspend fun authByToken(): AuthByTokenDomain {
        val result = networkDataSource.authByToken()
        return if(result.errorMsg.isEmpty()){
            result
        } else{
            AuthByTokenDomain(
                success = result.success,
                errorMsg = result.errorMsg
            )
        }
    }

    actual suspend fun confirmAuthAndReg(email: String, code: String): ConfirmAuthAndRegDomain {
        val result = networkDataSource.confirmAuthAndReg(email = email, code = code)
        return if(result.errorMsg.isEmpty()){
            localDataSource.saveUserTokenToLocal(result.userToken)
            localDataSource.saveRefreshTokenToLocal(result.userRefreshToken)
            ConfirmAuthAndRegDomain(
                success = result.success,
                userToken = result.userToken,
                userRefreshToken = result.userRefreshToken,
                errorMsg = result.errorMsg
            )
        } else result
    }

    actual suspend fun isUserExist(email: String): IsUserExistDomain {
        return networkDataSource.isUserExist(email = email)
    }

    actual suspend fun authByTokenOfflineLog(){
        delayedAuthByTokenLogger.sendLog()
    }

    actual suspend fun registrationByEmail(email: String): RegistrationByEmailDomain {
        return networkDataSource.registrationByEmail(email = email)
    }

    actual suspend fun checkAuthOfflineLogDataForIos() {
        val offlineLogData = localDataSource.checkOfflineAuthData()
        networkDataSource.sendOfflineAuthData(offlineLogData)
        localDataSource.clearOfflineAuthData()
    }
}