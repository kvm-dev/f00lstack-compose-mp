package ru.kvmsoft.features.professions.api.domain.usecase

import ru.kvmsoft.features.professions.api.model.ProfessionsDomain

interface GetProfessionsUseCase {

    suspend fun getProfessions(fromLocal: Boolean = false): ProfessionsDomain

    suspend fun getProfessionId():Int

    suspend fun saveProfessionId(professionId: Int)
}