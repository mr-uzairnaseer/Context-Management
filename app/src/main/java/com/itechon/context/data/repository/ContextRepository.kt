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

    suspend fun deleteContext(context: ContextEntity) {
        contextDao.deleteContext(context)
    }
}
