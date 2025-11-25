package ru.kvmsoft.features.comments.imp.mapper

import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain
import ru.kvmsoft.features.comments.imp.model.request.MaterialCommentRequest
import ru.kvmsoft.features.comments.imp.model.response.MaterialCommentResponse

object Mapper {

    fun mapToRequest(request: MaterialCommentRequestDomain): MaterialCommentRequest {
        return MaterialCommentRequest(
            comment = request.comment,
            materialId = request.materialId
        )
    }

    fun mapToResponse(response: MaterialCommentResponse): MaterialCommentResponseDomain {
        return MaterialCommentResponseDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }
}