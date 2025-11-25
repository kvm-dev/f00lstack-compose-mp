package ru.kvmsoft.features.authorization.imp.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kvmsoft.features.authorization.imp.data.network.NetworkDataSource
import kotlin.getValue
import kotlin.time.ExperimentalTime

class SendAuthByTokenOfflineLog(context: Context, workerParams: WorkerParameters)
    : CoroutineWorker(context, workerParams), KoinComponent {
    private val networkDataSource: NetworkDataSource by inject()

    @OptIn(ExperimentalTime::class)
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                // Perform send log task
                val currentTime = (kotlin.time.Clock.System.now().toEpochMilliseconds()) / 1000
                networkDataSource.authByTokenOfflineLog(timestamp = currentTime)
                Result.success()
            } catch (e: Exception) {
                Log.e("SyncCoroutineWorker", "Error syncing data", e)
                Result.failure()
            }
        }
    }
}
