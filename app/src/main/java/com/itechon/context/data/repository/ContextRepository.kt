package com.itechon.context.data.repository

import com.itechon.context.data.local.ContextDao
import com.itechon.context.data.local.ItemDao
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity
import kotlinx.coroutines.flow.Flow

class ContextRepository(
    private val contextDao: ContextDao,
    private val itemDao: ItemDao
) {
    val allContexts: Flow<List<ContextEntity>> = contextDao.getAllContexts()

    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>> {
        return itemDao.getItemsForContext(contextId)
    }

    suspend fun getContext(id: String): ContextEntity? {
        return contextDao.getContextById(id)
    }

    suspend fun createContext(context: ContextEntity) {
        contextDao.insertContext(context)
        // Ideally trigger sync work here
    }

    suspend fun createItem(item: ItemEntity) {
        itemDao.insertItem(item)
    }

    suspend fun updateContext(context: ContextEntity) {
        contextDao.insertContext(context)
    }

    suspend fun getDirtyContexts(): List<ContextEntity> {
        return contextDao.getDirtyContexts()
    }

    suspend fun getDirtyItems(): List<ItemEntity> {
        return itemDao.getDirtyItems()
    }

    suspend fun markContextSynced(contextId: String) {
        val context = contextDao.getContextById(contextId)
        context?.let {
            contextDao.insertContext(it.copy(syncStatus = "SYNCED"))
        }
    }

    suspend fun markItemSynced(itemId: String) {
        val item = itemDao.getItemById(itemId)
        item?.let {
            itemDao.insertItem(it.copy(syncStatus = "SYNCED"))
        }
    }

    suspend fun deleteContext(context: ContextEntity) {
        // Soft delete: Mark as DELETED and DIRTY so SyncWorker can propagate it
        val deletedContext = context.copy(syncStatus = "DELETED")
        contextDao.insertContext(deletedContext)
    }

    suspend fun clearAllData() {
        contextDao.deleteAllContexts()
        itemDao.deleteAllItems()
    }
}
