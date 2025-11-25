package ru.kvmsoft.features.comments.api.domain.usecase

import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain

interface SendMaterialCommentUseCase {

    suspend fun sendCommentOnline(request: MaterialCommentRequestDomain): MaterialCommentResponseDomain
    suspend fun sendCommentOffline(request: MaterialCommentRequestDomain)
    suspend fun checkOfflineCommentsDataForIos()

}