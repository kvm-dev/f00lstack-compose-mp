package ru.kvmsoft.features.comments.imp.data.repository

import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.imp.data.local.LocalDataSource
import ru.kvmsoft.features.comments.imp.data.network.NetworkDataSource

actual class CommentsRepository(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) {
    actual suspend fun sendMaterialComment(requestDomain: MaterialCommentRequestDomain): ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain {
        return networkDataSource.sendMaterialComment(requestDomain)
    }

    actual suspend fun sendCommentOffline(requestDomain: MaterialCommentRequestDomain) {
        localDataSource.saveOfflineCommentData(materialId = requestDomain.materialId, materialComment = requestDomain.comment)
    }

    actual suspend fun checkOfflineCommentsDataForIos() {
        val offlineLogData = localDataSource.checkOfflineCommentData()
        networkDataSource.sendOfflineCommentsData(offlineLogData)
        localDataSource.clearOfflineCommentData()
    }
}