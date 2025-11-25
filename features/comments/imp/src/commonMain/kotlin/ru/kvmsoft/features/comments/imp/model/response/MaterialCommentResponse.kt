package ru.kvmsoft.features.comments.imp.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MaterialCommentResponse(
    @SerialName("success") val success: Boolean = false,
    @SerialName("errorMsg") val errorMsg: String
)