package ru.kvmsoft.features.tests.imp.data.network

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import ru.kvmsoft.features.tests.imp.data.worker.SendTestResultOffline

class LocalTestResultSender(val platformContext: Context) {

    fun sendLog() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<SendTestResultOffline>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(platformContext).enqueue(workRequest)
    }
}