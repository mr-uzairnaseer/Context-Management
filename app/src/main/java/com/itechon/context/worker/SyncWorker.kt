package com.itechon.context.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.itechon.context.ContextApp
import com.itechon.context.data.repository.ContextRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import io.github.jan.supabase.postgrest.postgrest
import com.itechon.context.data.remote.SupabaseModule

class SyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val app = applicationContext as ContextApp
        val repository = app.repository
        
        try {
            // 1. Sync Contexts
            val dirtyContexts = repository.getDirtyContexts()
            dirtyContexts.forEach { context ->
                SupabaseModule.client.postgrest["contexts"].upsert(context)
                repository.markContextSynced(context.id)
            }
            
            // 2. Sync Items
            val dirtyItems = repository.getDirtyItems()
            dirtyItems.forEach { item ->
                SupabaseModule.client.postgrest["items"].upsert(item)
                repository.markItemSynced(item.id)
            }
            
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            if (runAttemptCount < 3) {
                 Result.retry()
            } else {
                 Result.failure()
            }
        }
    }
}
