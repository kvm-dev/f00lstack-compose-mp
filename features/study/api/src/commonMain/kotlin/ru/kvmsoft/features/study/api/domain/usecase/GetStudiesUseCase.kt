package ru.kvmsoft.features.study.api.domain.usecase

import ru.kvmsoft.features.study.api.model.StudiesDomain

interface GetStudiesUseCase {

    suspend fun getStudies(fromLocal: Boolean = false): StudiesDomain
}