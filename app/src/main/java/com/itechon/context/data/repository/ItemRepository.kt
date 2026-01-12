package com.itechon.context.data.repository

import com.itechon.context.data.local.ItemDao
import com.itechon.context.data.model.ItemEntity
import kotlinx.coroutines.flow.Flow

class ItemRepository(
    private val itemDao: ItemDao
) {
    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>> {
        return itemDao.getItemsForContext(contextId)
    }

    suspend fun insertItem(item: ItemEntity) {
        itemDao.insertItem(item)
    }

    suspend fun deleteItem(item: ItemEntity) {
        itemDao.deleteItem(item)
    }

    suspend fun getDirtyItems(): List<ItemEntity> {
        return itemDao.getDirtyItems()
    }
}
