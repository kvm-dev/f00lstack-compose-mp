package ru.kvmsoft.features.comments.imp.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kvmsoft.features.comments.api.model.request.MaterialCommentRequestDomain
import ru.kvmsoft.features.comments.imp.data.local.LocalDataSource
import ru.kvmsoft.features.comments.imp.data.network.NetworkDataSource
import kotlin.getValue
import kotlin.time.ExperimentalTime

class SendCommentOffline(context: Context, workerParams: WorkerParameters)
    : CoroutineWorker(context, workerParams), KoinComponent {
    private val networkDataSource: NetworkDataSource by inject()
    private val localDataSource: LocalDataSource by inject()

    @OptIn(ExperimentalTime::class)
    override suspend fun doWork(): Result {
        val comments = localDataSource.checkOfflineCommentData()
        return withContext(Dispatchers.IO) {
            try {
                if(comments.isNotEmpty())
                    comments.forEach { comment->
                        networkDataSource.sendMaterialComment(
                            MaterialCommentRequestDomain(
                                materialId = comment.materialId,
                                comment = comment.commentText
                            )
                        )
                    }
                localDataSource.clearOfflineCommentData()
                // Perform send log task

                Result.success()
            } catch (e: Exception) {
                Log.e("SyncCoroutineWorker", "Error syncing data", e)
                Result.failure()
            }
        }
    }
}
