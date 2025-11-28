package ru.kvmsoft.features.tests.api.domain.usecase

import ru.kvmsoft.features.tests.api.model.request.SendRequestDomain
import ru.kvmsoft.features.tests.api.model.response.SendResultDomain

interface SendTestResultUseCase {

    suspend fun sendTestResult(request: SendRequestDomain, toLocal: Boolean = false): SendResultDomain
}