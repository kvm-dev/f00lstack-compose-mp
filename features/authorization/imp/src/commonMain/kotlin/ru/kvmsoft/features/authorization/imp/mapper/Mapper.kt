package ru.kvmsoft.features.authorization.imp.mapper

import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import ru.kvmsoft.features.authorization.api.model.AuthByTokenDomain
import ru.kvmsoft.features.authorization.api.model.ConfirmAuthAndRegDomain
import ru.kvmsoft.features.authorization.api.model.IsUserExistDomain
import ru.kvmsoft.features.authorization.api.model.RegistrationByEmailDomain
import ru.kvmsoft.features.authorization.imp.model.response.AuthByEmailResponse
import ru.kvmsoft.features.authorization.imp.model.response.AuthByTokenResponse
import ru.kvmsoft.features.authorization.imp.model.response.ConfirmAuthAndRegResponse
import ru.kvmsoft.features.authorization.imp.model.response.IsUserExistResponse
import ru.kvmsoft.features.authorization.imp.model.response.RegistrationByEmailResponse

object Mapper {

    fun map(response: AuthByEmailResponse): AuthByEmailDomain {
        return AuthByEmailDomain(
            userToken = response.userToken,
            userRefreshToken = response.userRefreshToken,
            errorMsg = response.errorMsg)
    }

    fun map(response: AuthByTokenResponse): AuthByTokenDomain {
        return AuthByTokenDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }

    fun map(response: ConfirmAuthAndRegResponse): ConfirmAuthAndRegDomain {
        return ConfirmAuthAndRegDomain(
            success = response.success,
            userToken = response.userToken,
            userRefreshToken = response.userRefreshToken,
            errorMsg = response.errorMsg
        )
    }

    fun map(response: IsUserExistResponse): IsUserExistDomain {
        return IsUserExistDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }

    fun map(response: RegistrationByEmailResponse): RegistrationByEmailDomain {
        return RegistrationByEmailDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }
}