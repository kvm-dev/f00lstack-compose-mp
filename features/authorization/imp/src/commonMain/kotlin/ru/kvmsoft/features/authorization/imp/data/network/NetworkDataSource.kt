package ru.kvmsoft.features.authorization.imp.data.network

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain
import ru.kvmsoft.features.authorization.imp.mapper.Mapper
import ru.kvmsoft.features.authorization.imp.model.request.AuthByTokenOfflineLogRequest
import ru.kvmsoft.features.authorization.imp.model.response.AuthByTokenOfflineResponse
import ru.kvmsoft.base.storage.model.OfflineAuthData as StorageAuthData

class NetworkDataSource(private val api: AuthorizationApi){

    suspend fun authByEmail(email: String, code: String): AuthByEmailDomain {
        return Mapper.map(api.authByEmail(email = email, code = code))
    }

    suspend fun authByToken(): AuthByTokenDomain {
        return Mapper.map(api.authByToken())
    }

    suspend fun confirmAuthAndReg(email:String, code: String): ConfirmAuthAndRegDomain {
        return Mapper.map(api.confirmAuthAndReg(email = email, code = code))
    }

    suspend fun isUserExist(email: String): IsUserExistDomain {
        return Mapper.map(api.isUserExist(email))
    }

    suspend fun authByTokenOfflineLog(timestamp: Long): AuthByTokenOfflineResponse {
        return api.sendAuthByTokenOfflineLog(request = AuthByTokenOfflineLogRequest(timestamp = timestamp))
    }

    suspend fun registrationByEmail(email: String): RegistrationByEmailDomain {
        return Mapper.map(api.registrationByEmail(email = email))
    }
    suspend fun sendOfflineAuthData(authData: List<StorageAuthData>){
        if(authData.isNotEmpty()){
            authData.forEach { authLogData->
                api.sendAuthByTokenOfflineLog(Mapper.map(authLogData))
            }
        }
    }

}