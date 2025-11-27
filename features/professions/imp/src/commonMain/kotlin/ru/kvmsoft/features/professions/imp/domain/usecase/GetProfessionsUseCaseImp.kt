package ru.kvmsoft.features.professions.imp.domain.usecase

import ru.kvmsoft.features.professions.api.domain.usecase.GetProfessionsUseCase
import ru.kvmsoft.features.professions.api.model.ProfessionsDomain
import ru.kvmsoft.features.professions.imp.data.repository.ProfessionsRepository

class GetProfessionsUseCaseImp(private val repository: ProfessionsRepository):
    GetProfessionsUseCase {

    override suspend fun getProfessions(fromLocal: Boolean): ProfessionsDomain {
        return if(fromLocal){
            repository.getProfessionsFromLocal()
        } else {
            repository.getProfessionsFromServer()
        }
    }

    override suspend fun getProfessionId() = repository.getProfessionId()

    override suspend fun saveProfessionId(professionId: Int)  = repository.saveProfessionId(professionId)
}