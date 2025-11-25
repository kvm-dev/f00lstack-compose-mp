package ru.kvmsoft.features.comments.imp.data.repository

import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain
import ru.kvmsoft.features.comments.imp.data.local.LocalDataSource
import ru.kvmsoft.features.comments.imp.data.network.DelayedCommentsSender
import ru.kvmsoft.features.comments.imp.data.network.NetworkDataSource

actual class CommentsRepository(
    private val delayedCommentsSender: DelayedCommentsSender,
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource) {

    actual suspend fun sendMaterialComment(requestDomain: MaterialCommentRequestDomain): MaterialCommentResponseDomain {
        return networkDataSource.sendMaterialComment(requestDomain)
    }

    actual suspend fun sendCommentOffline(requestDomain: MaterialCommentRequestDomain) {
        delayedCommentsSender.sendOfflineComments()
    }

    actual suspend fun checkOfflineCommentsDataForIos() {
    }
}