package ru.kvmsoft.features.tests.imp.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kvmsoft.features.tests.imp.data.local.LocalDataSource
import ru.kvmsoft.features.tests.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.tests.imp.mapper.Mapper
import kotlin.time.ExperimentalTime

class SendTestResultOffline(context: Context, workerParams: WorkerParameters)
    : CoroutineWorker(context, workerParams), KoinComponent {
    private val networkDataSource: NetworkDataSource by inject()
    private val localDataSource: LocalDataSource by inject()

    @OptIn(ExperimentalTime::class)
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                // Perform send log task
                val result = localDataSource.getLocalTestResult()
                if(result.isNotEmpty()){
                    result.forEach { result->
                        networkDataSource.sendTestResult(Mapper.mapToTestResultRequestFromOfflineTestResult(result))
                    }
                }
                localDataSource.clearLocalTestResult()

                Result.success()
            } catch (e: Exception) {
                Log.e("SyncCoroutineWorker", "Error syncing data", e)
                Result.failure()
            }
        }
    }
}