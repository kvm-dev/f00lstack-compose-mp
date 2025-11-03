package ru.kvmsoft.features.authorization.imp.data.datasource.network

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import ru.kvmsoft.features.authorization.imp.data.worker.SendAuthByTokenOfflineLog

class DelayedAuthByTokenLogger(val platformContext: Context) {

    fun sendLog() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<SendAuthByTokenOfflineLog>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(platformContext).enqueue(workRequest)
    }
}