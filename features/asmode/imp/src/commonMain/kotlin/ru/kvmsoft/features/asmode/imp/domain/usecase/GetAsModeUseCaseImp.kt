package ru.kvmsoft.features.asmode.imp.domain.usecase

import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.asmode.api.model.AsModeDomain
import ru.kvmsoft.features.asmode.imp.data.repository.AsModeRepository

class GetAsModeUseCaseImp(private val repository: AsModeRepository): GetAsModeUseCase {
    override suspend fun isAsModeEnabled(isConnectionAvailable: Boolean): AsModeDomain {
        return repository.isAsEnabled(isConnectionAvailable)
    }
}