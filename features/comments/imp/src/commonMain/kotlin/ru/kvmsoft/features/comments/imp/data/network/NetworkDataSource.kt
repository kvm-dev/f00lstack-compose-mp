package ru.kvmsoft.features.comments.imp.data.network

import ru.kvmsoft.base.storage.model.OfflineAuthData
import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.api.model.response.MaterialCommentResponseDomain
import ru.kvmsoft.features.comments.imp.mapper.Mapper
import ru.kvmsoft.features.comments.imp.model.request.MaterialCommentRequest
import ru.kvmsoft.base.storage.model.OfflineComment as StorageComment

class NetworkDataSource(private val api: CommentsApi){

    suspend fun sendMaterialComment(request: MaterialCommentRequestDomain): MaterialCommentResponseDomain {
        return Mapper.mapToResponse(api.sendMaterialComment(request = Mapper.mapToRequest(request)))
    }

    suspend fun sendOfflineCommentsData(comments: List<StorageComment>){
        if(comments.isNotEmpty()){
            comments.forEach { offlineComment->
                api.sendMaterialComment(MaterialCommentRequest(materialId = offlineComment.materialId, comment = offlineComment.commentText))
            }
        }
    }
}