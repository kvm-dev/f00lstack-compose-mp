package ru.kvmsoft.base.network.utils

import io.ktor.http.HttpStatusCode
import ru.kvmsoft.base.network.model.NetworkError

fun exceptionHandler(statusCode: HttpStatusCode): Throwable{
    return when (statusCode) {
        HttpStatusCode.BadRequest -> NetworkError.BadRequest()
        HttpStatusCode.Unauthorized -> NetworkError.Unauthorized()
        HttpStatusCode.Forbidden -> NetworkError.Forbidden()
        HttpStatusCode.NotFound -> NetworkError.NotFound()
        HttpStatusCode.RequestTimeout -> NetworkError.RequestTimeOut()
        HttpStatusCode.InternalServerError -> NetworkError.InternalServerError()
        HttpStatusCode.ExpectationFailed -> NetworkError.ExpectationFailed()
        else->NetworkError.UnknownError()
    }
}
