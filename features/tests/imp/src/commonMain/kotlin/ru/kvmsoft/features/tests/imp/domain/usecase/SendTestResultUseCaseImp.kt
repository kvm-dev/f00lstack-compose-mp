package ru.kvmsoft.features.tests.imp.domain.usecase

import ru.kvmsoft.features.tests.api.domain.usecase.SendTestResultUseCase
import ru.kvmsoft.features.tests.api.model.request.SendRequestDomain
import ru.kvmsoft.features.tests.api.model.response.SendResultDomain
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

class SendTestResultUseCaseImp(private val repository: TestsRepository): SendTestResultUseCase {

    override suspend fun sendTestResult(
        request: SendRequestDomain,
        toLocal: Boolean
    ): SendResultDomain {
        return if(toLocal){
            repository.sendTestResultToLocal(requestDomain =  request)
        } else{
            repository.sendTestResultToServer(requestDomain = request)
        }
    }
}