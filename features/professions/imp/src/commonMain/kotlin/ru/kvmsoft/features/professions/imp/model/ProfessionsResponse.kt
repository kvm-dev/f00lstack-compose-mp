package ru.kvmsoft.features.professions.imp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionsResponse(
    @SerialName("errorMsg")
    val errorMsg: String = "",
    @SerialName("professions")
    val professions: List<ProfessionResponse> = listOf(),
    @SerialName("success")
    val success: Boolean = false
)

@Serializable
data class ProfessionResponse(
    @SerialName("professionId")
    val professionId: Int = 0,
    @SerialName("professionImage")
    val professionImage: String = "",
    @SerialName("professionName")
    val professionName: String = "",
    @SerialName("professionParent")
    val professionParent: Int = 0,
    @SerialName("professionPriority")
    val professionPriority: Int = 0,
    @SerialName("professionType")
    val professionType: Int = 0,
    @SerialName("subProfessions")
    val subProfessions: List<ProfessionResponse> = listOf()
)