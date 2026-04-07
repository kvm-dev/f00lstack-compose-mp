package ru.kvmsoft.base.utils

import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.base.utils.res.strings.getErrorExpectationLocal
import ru.kvmsoft.base.utils.res.strings.getErrorExpectationPlatform
import ru.kvmsoft.base.utils.res.strings.getErrorExpectationUserType
import ru.kvmsoft.base.utils.res.strings.getErrorExpectationVersion
import ru.kvmsoft.base.utils.res.strings.getErrorTokenIsExpired
import ru.kvmsoft.base.utils.res.strings.getErrorUserIsBlocked
import ru.kvmsoft.base.utils.res.strings.getErrorUserIsUnauthorized
import ru.kvmsoft.base.utils.res.strings.getLocalDataBaseError

fun errorsMsgHandler(errorMsg: String?): BaseErrors {
    return when (errorMsg) {
        getErrorExpectationPlatform(), getErrorExpectationVersion(), getErrorExpectationUserType(), getErrorExpectationLocal() -> BaseErrors.EXPECTATION_HEADERS
        getErrorTokenIsExpired()-> BaseErrors.TOKEN_EXPIRED
        getErrorUserIsUnauthorized()-> BaseErrors.UNAUTHORIZED
        getErrorUserIsBlocked() -> BaseErrors.USER_IS_BLOCKED
        getLocalDataBaseError() -> BaseErrors.LOCAL_DATABASE_ERROR
        else -> BaseErrors.UNKNOWN_ERROR
    }
}