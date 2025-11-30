package ru.kvmsoft.features.study.imp.data.network

import ru.kvmsoft.features.study.api.model.StudiesDomain
import ru.kvmsoft.features.study.api.model.StudyDomain
import ru.kvmsoft.features.study.imp.mapper.Mapper
import ru.kvmsoft.features.study.imp.model.StudiesVersionResponse

class NetworkDataSource(private val api: StudyApi){

    suspend fun getStudies(): StudiesDomain {
        val response = api.getStudies()
        val studiesList = ArrayList<StudyDomain>()
        response.studies.forEach { study->
            studiesList.add(Mapper.map(study))
        }
        return StudiesDomain(
            studies = studiesList,
            prText = response.prText,
            errorMsg = response.errorMsg)
    }

    suspend fun getVersion(): StudiesVersionResponse {
        return api.getVersion()
    }
}