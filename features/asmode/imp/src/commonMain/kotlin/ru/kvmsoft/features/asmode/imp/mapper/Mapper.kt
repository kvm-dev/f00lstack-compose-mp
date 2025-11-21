package ru.kvmsoft.features.asmode.imp.mapper

import ru.kvmsoft.features.asmode.api.model.AsModeDomain
import ru.kvmsoft.features.asmode.imp.model.AsModeResponse

object Mapper {
    fun mapToAsModeDomain(response: AsModeResponse): AsModeDomain {
        return AsModeDomain(
            isAsModeActive = response.isAsModeActive
        )
    }
}