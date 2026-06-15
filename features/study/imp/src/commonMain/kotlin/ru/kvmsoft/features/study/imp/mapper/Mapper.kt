package ru.kvmsoft.features.study.imp.mapper

import ru.kvmsoft.base.storage.model.ProfessionListItem
import ru.kvmsoft.base.storage.model.Studies
import ru.kvmsoft.base.storage.model.Study
import ru.kvmsoft.base.ui.model.Chip
import ru.kvmsoft.base.ui.model.StudiesItemState
import ru.kvmsoft.base.ui.model.StudyItem
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.features.study.api.model.StudiesDomain
import ru.kvmsoft.features.study.api.model.StudyDomain
import ru.kvmsoft.features.study.api.model.StudyProfessionDomain
import ru.kvmsoft.features.study.imp.model.StudyResponse

object Mapper {

    fun map(response: StudyResponse): StudyDomain {
        val professions = ArrayList<StudyProfessionDomain>()
        response.professions.forEach { profession->
            professions.add(StudyProfessionDomain(
                professionId = profession.professionId,
                professionName = profession.professionName
            ))
        }
        return StudyDomain(
            studyId = response.studyId,
            studyName = response.studyName,
            studyCost = response.studyCost,
            studyImageBase64 = response.studyImage,
            studyRefLink = response.studyRefLink,
            studySalePercent = response.studySalePercent,
            studyLength = response.studyLength,
            studyLengthType = response.studyLengthType,
            professions = professions,
            studyOwner = response.studyOwner,
            studyAdditionalText = response.studyAdditionalText
        )
    }

    fun map(response: StudiesDomain): Studies {
        val studiesList = ArrayList<Study>()
        response.studies.forEach { study->
            val professions = ArrayList<ProfessionListItem>()
            study.professions.forEach { profession->
                professions.add(ProfessionListItem(
                    professionId = profession.professionId,
                    professionName = profession.professionName
                ))
            }
            studiesList.add(
                Study(
                    studyId = study.studyId,
                    studyName = study.studyName,
                    studyCost = study.studyCost,
                    studyLength = study.studyLength,
                    studyLengthType = study.studyLengthType,
                    studyAdditionalText = study.studyAdditionalText,
                    studyOwner = study.studyOwner,
                    studySalePercent = study.studySalePercent,
                    studyImageBase64 = study.studyImageBase64,
                    studyRefLink = study.studyRefLink,
                    professions = professions
                )
            )
        }
        return Studies(
            studies = studiesList,
            prText = response.prText,
            errorMsg = response.errorMsg
        )
    }

    fun map(response: Studies): StudiesDomain {
        val studiesList = ArrayList<StudyDomain>()
        response.studies.forEach { study->
            val professions = ArrayList<StudyProfessionDomain>()
            study.professions.forEach { profession->
                professions.add(StudyProfessionDomain(
                    professionId = profession.professionId,
                    professionName = profession.professionName
                ))
            }
            studiesList.add(
                StudyDomain(
                    studyId = study.studyId,
                    studyName = study.studyName,
                    studyCost = study.studyCost,
                    studyLength = study.studyLength,
                    studyLengthType = study.studyLengthType,
                    studyAdditionalText = study.studyAdditionalText,
                    studyOwner = study.studyOwner,
                    studySalePercent = study.studySalePercent,
                    studyImageBase64 = study.studyImageBase64,
                    studyRefLink = study.studyRefLink,
                    professions = professions
                )
            )
        }
        return StudiesDomain(
            studies = studiesList,
            prText = response.prText,
            errorMsg = response.errorMsg
        )
    }

    fun mapToChips(studiesState: UiState<StudiesItemState>, isAsMode: Boolean): List<Chip>{
        val list = HashSet<Chip>()
        if (studiesState is UiState.Success){
            if(isAsMode){
                studiesState.data?.studies?.filter { it.studyCost == 0 }?.forEach { study->
                    study.studyTags.forEach { sub->
                        list.add(Chip(id = study.studyId, name = sub.name))
                    }
                }
            }
            else{
                studiesState.data?.studies?.forEach { study->
                    study.studyTags.forEach { sub->
                        list.add(sub)
                    }
                }
            }
        }
        return list.toList()
    }

    fun List<StudyDomain>.mapToStudiesItems(): List<StudyItem>{
        val list = ArrayList<StudyItem>()
        if(this.isNotEmpty()){
            this.forEach {  study->
                val tags = ArrayList<Chip>()
                tags.clear()
                study.professions.forEach { sub->
                    tags.add(Chip(id = sub.professionId, name = sub.professionName))
                }
                list.add(StudyItem(
                    studyId = study.studyId,
                    studyName = study.studyName,
                    studySalePercent = study.studySalePercent,
                    studyLength = study.studyLength,
                    studyLengthType = study.studyLengthType,
                    studyAdditionalText = study.studyAdditionalText,
                    studyCost = study.studyCost,
                    studyImageBase64 = study.studyImageBase64,
                    studyTags = tags,
                    studyRefLink = study.studyRefLink,
                    studyOwner = study.studyOwner
                ))
            }
        }
        return list
    }
}