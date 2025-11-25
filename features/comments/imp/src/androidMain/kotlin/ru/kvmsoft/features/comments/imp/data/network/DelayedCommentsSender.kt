package ru.kvmsoft.features.comments.imp.data.network

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import ru.kvmsoft.features.comments.imp.data.worker.SendCommentOffline

class DelayedCommentsSender(val platformContext: Context) {

    fun sendOfflineComments() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<SendCommentOffline>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(platformContext).enqueue(workRequest)
    }
}