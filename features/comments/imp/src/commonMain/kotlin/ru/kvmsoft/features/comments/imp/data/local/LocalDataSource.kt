package ru.kvmsoft.features.comments.imp.data.local

import ru.kvmsoft.base.storage.data.DataBaseSDK
import ru.kvmsoft.base.storage.model.OfflineComment
import kotlin.time.ExperimentalTime

class LocalDataSource(private val dataBaseSDK: DataBaseSDK) {
    suspend fun saveOfflineCommentData(materialId: Int, materialComment: String){
        dataBaseSDK.saveOfflineComment(OfflineComment(materialId, materialComment))

    }

    @OptIn(ExperimentalTime::class)
    suspend fun clearOfflineCommentData(){
        dataBaseSDK.clearOfflineComments()

    }

    suspend fun checkOfflineCommentData() = dataBaseSDK.getOfflineComments()
}