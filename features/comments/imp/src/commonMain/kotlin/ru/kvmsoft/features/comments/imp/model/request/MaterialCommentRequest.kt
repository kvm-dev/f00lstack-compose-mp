package ru.kvmsoft.features.comments.imp.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MaterialCommentRequest(
    @SerialName("materialId") val materialId: Int,
    @SerialName("comment") val comment: String
)