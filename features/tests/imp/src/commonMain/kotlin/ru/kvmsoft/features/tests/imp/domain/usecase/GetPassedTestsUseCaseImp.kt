package ru.kvmsoft.features.tests.imp.domain.usecase

import ru.kvmsoft.features.tests.api.domain.usecase.GetPassedTestsUseCase
import ru.kvmsoft.features.tests.api.model.response.PassedTestsDomain
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

class GetPassedTestsUseCaseImp(private val repository: TestsRepository): GetPassedTestsUseCase {

    override suspend fun getPassedTests(fromLocal: Boolean): PassedTestsDomain {
        return if(fromLocal){
            repository.getPassedTestsFromLocal()
        }
        else{
            repository.getPassedTestsFromServer()
        }
    }
}