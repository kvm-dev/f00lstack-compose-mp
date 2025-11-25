package ru.kvmsoft.features.comments.imp.domain.usecase

import ru.kvmsoft.features.comments.api.domain.usecase.SendMaterialCommentUseCase
import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain
import ru.kvmsoft.features.comments.imp.data.repository.CommentsRepository

class SendMaterialCommentUseCaseImp(private val repository: CommentsRepository): SendMaterialCommentUseCase {
    override suspend fun sendCommentOnline(request: MaterialCommentRequestDomain): MaterialCommentResponseDomain {
        return repository.sendMaterialComment(request)
    }

    override suspend fun sendCommentOffline(request: MaterialCommentRequestDomain) {
        repository.sendCommentOffline(request)
    }

    override suspend fun checkOfflineCommentsDataForIos() {
        repository.checkOfflineCommentsDataForIos()
    }
}