package ru.kvmsoft.features.comments.imp.data.repository

import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain

expect class CommentsRepository{

    suspend fun sendMaterialComment(requestDomain: MaterialCommentRequestDomain): MaterialCommentResponseDomain

    suspend fun sendCommentOffline(requestDomain: MaterialCommentRequestDomain)

    suspend fun checkOfflineCommentsDataForIos()
}