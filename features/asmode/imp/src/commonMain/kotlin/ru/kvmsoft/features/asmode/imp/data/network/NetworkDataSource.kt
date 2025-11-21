package ru.kvmsoft.features.asmode.imp.data.network

import ru.kvmsoft.features.asmode.api.model.AsModeDomain
import ru.kvmsoft.features.asmode.imp.mapper.Mapper

class NetworkDataSource(private val api: AsModeApi){

    suspend fun getAsModeStatus(): AsModeDomain = Mapper.mapToAsModeDomain(api.getAsMode())
}