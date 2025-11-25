package ru.kvmsoft.features.comments.api.model.request

data class MaterialCommentRequestDomain(
    val materialId: Int,
    val comment: String
)