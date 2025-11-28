package ru.kvmsoft.features.tests.imp.domain.usecase

import ru.kvmsoft.features.tests.api.domain.usecase.GetTestsUseCase
import ru.kvmsoft.features.tests.api.model.response.TestsDomain
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

class GetTestsUseCaseImp(private val repository: TestsRepository): GetTestsUseCase {

    override suspend fun getTests(fromLocal: Boolean): TestsDomain {
        return if(fromLocal){
            repository.getTestsFromLocal()
        }
        else{
            repository.getTestsFromServer()
        }
    }

    override suspend fun getTestsByProfession(professionId: Int, fromLocal: Boolean): TestsDomain {

        return if(fromLocal){
            repository.getTestsFromLocal()
        }
        else{
            repository.getTestsByProfessionFromServer(professionId)
        }
    }
}