package ru.kvmsoft.features.asmode.api.domain.usecase

import ru.kvmsoft.features.asmode.api.model.AsModeDomain

interface GetAsModeUseCase {
    suspend fun isAsModeEnabled(isConnectionAvailable: Boolean): AsModeDomain
}