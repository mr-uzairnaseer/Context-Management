package com.itechon.context.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.itechon.context.ContextApp
import com.itechon.context.data.repository.ContextRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.filter.FilterOperator
import com.itechon.context.data.remote.SupabaseModule
import kotlinx.datetime.Instant

class SyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val app = applicationContext as ContextApp
        val repository = app.repository
        val itemDao = app.database.itemDao()
        val contextDao = app.database.contextDao()
        
        try {
            // --- PUSH: Upload local changes to Supabase ---

            // 1. Sync Contexts
            val dirtyContexts = repository.getDirtyContexts()
            dirtyContexts.forEach { context ->
                if (context.syncStatus == "DELETED") {
                    SupabaseModule.client.postgrest["contexts"].delete {
                        filter {
                            eq("id", context.id)
                        }
                    }
                    contextDao.deleteContextById(context.id)
                } else {
                    // When sending to Supabase, we should probably not send "syncStatus" or set it to SYNCED?
                    // Supabase likely doesn't have "syncStatus" column unless we added it.
                    // Assuming we ignore it or it's fine.
                    SupabaseModule.client.postgrest["contexts"].upsert(context)
                    repository.markContextSynced(context.id)
                }
            }
            
            // 2. Sync Items
            val dirtyItems = repository.getDirtyItems()
            dirtyItems.forEach { item ->
                if (item.syncStatus == "DELETED") {
                     SupabaseModule.client.postgrest["items"].delete {
                        filter {
                            eq("id", item.id)
                        }
                    }
                    itemDao.deleteItem(item)
                } else {
                    SupabaseModule.client.postgrest["items"].upsert(item)
                    repository.markItemSynced(item.id)
                }
            }

            // --- PULL: Fetch latest changes from Supabase ---
            
            // Get last sync timestamp using standard SharedPreferences
            val sharedPrefs = applicationContext.getSharedPreferences("sync_prefs", Context.MODE_PRIVATE)
            val lastSyncedAtStr = sharedPrefs.getString("last_synced_at", null)
            
            // Contexts
            val remoteContextsQuery = SupabaseModule.client.postgrest["contexts"].select()
            val remoteContexts = if (lastSyncedAtStr != null) {
                // If we have a timestamp, we want new data.
                // Since we are parsing manually, ensure the variable is treated as a String
                val pivot = Instant.parse(lastSyncedAtStr)
                remoteContextsQuery.decodeList<com.itechon.context.data.model.ContextEntity>()
                    .filter { it.updatedAt > pivot } 
            } else {
                 remoteContextsQuery.decodeList<com.itechon.context.data.model.ContextEntity>()
            }
            
            remoteContexts.forEach { remote ->
                contextDao.insertContext(remote.copy(syncStatus = "SYNCED"))
            }

            // Items 
            val remoteItemsQuery = SupabaseModule.client.postgrest["items"].select()
             val remoteItems = if (lastSyncedAtStr != null) {
                val pivot = Instant.parse(lastSyncedAtStr)
                remoteItemsQuery.decodeList<com.itechon.context.data.model.ItemEntity>()
                    .filter { it.timestamp > pivot }
            } else {
                remoteItemsQuery.decodeList<com.itechon.context.data.model.ItemEntity>()
            }

            remoteItems.forEach { remote ->
                 itemDao.insertItem(remote.copy(syncStatus = "SYNCED"))
            }

            // Update last synced time
            sharedPrefs.edit().putString("last_synced_at", kotlinx.datetime.Clock.System.now().toString()).apply()
            
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
