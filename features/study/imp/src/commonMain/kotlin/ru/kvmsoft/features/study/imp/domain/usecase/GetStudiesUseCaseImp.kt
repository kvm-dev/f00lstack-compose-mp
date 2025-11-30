package ru.kvmsoft.features.study.imp.domain.usecase

import ru.kvmsoft.features.study.api.domain.usecase.GetStudiesUseCase
import ru.kvmsoft.features.study.api.model.StudiesDomain
import ru.kvmsoft.features.study.imp.data.repository.StudyRepository

class GetStudiesUseCaseImp(private val repository: StudyRepository): GetStudiesUseCase {

    override suspend fun getStudies(fromLocal: Boolean): StudiesDomain {
        return if(fromLocal){
            repository.getStudiesFromLocal()
        }
        else{
            repository.getStudiesFromServer()
        }
    }
}