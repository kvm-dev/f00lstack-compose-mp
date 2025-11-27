package ru.kvmsoft.features.professions.imp.data.network

import ru.kvmsoft.features.professions.api.model.ProfessionDomain
import ru.kvmsoft.features.professions.api.model.ProfessionsDomain
import ru.kvmsoft.features.professions.imp.mapper.Mapper

class NetworkDataSource(private val api: ProfessionsApi) {

    suspend fun getProfessions(): ProfessionsDomain {
        val response = api.getProfessions()
        val professionsList = HashSet<ProfessionDomain>()
        response.professions.forEach { profession ->

            professionsList.add(Mapper.recursiveProfessionsMapping(profession))
            if (profession.subProfessions.isNotEmpty()) {
                response.professions.forEach { subProfLvl1 ->
                    professionsList.add(
                        Mapper.recursiveProfessionsMapping(
                            subProfLvl1
                        )
                    )
                    if (subProfLvl1.subProfessions.isNotEmpty()) {
                        subProfLvl1.subProfessions.forEach { subProfLvl2 ->
                            professionsList.add(
                                Mapper.recursiveProfessionsMapping(
                                    subProfLvl2
                                )
                            )
                            if (subProfLvl2.subProfessions.isNotEmpty()) {
                                subProfLvl2.subProfessions.forEach { subProfLvl3 ->
                                    professionsList.add(
                                        Mapper.recursiveProfessionsMapping(
                                            subProfLvl3
                                        )
                                    )
                                    if (subProfLvl3.subProfessions.isNotEmpty()) {
                                        subProfLvl3.subProfessions.forEach { subProfLvl4 ->
                                            professionsList.add(
                                                Mapper.recursiveProfessionsMapping(
                                                    subProfLvl4
                                                )
                                            )
                                            if (subProfLvl4.subProfessions.isNotEmpty()) {
                                                subProfLvl4.subProfessions.forEach { subProfLvl5 ->
                                                    professionsList.add(
                                                        Mapper.recursiveProfessionsMapping(
                                                            subProfLvl5
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ProfessionsDomain(
            success = response.success,
            professions = Mapper.correctListProfessions(professionsList),
            errorMsg = response.errorMsg
        )
    }
}