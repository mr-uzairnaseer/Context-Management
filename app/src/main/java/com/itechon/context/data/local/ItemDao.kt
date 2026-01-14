package com.itechon.context.data.local

import androidx.room.*
import com.itechon.context.data.model.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM items WHERE contextId = :contextId AND syncStatus != 'DELETED' ORDER BY timestamp DESC")
    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE syncStatus != 'DELETED' ORDER BY timestamp DESC")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE content LIKE '%' || :query || '%' AND syncStatus != 'DELETED' ORDER BY timestamp DESC")
    fun searchItems(query: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE syncStatus = 'DIRTY'")
    suspend fun getDirtyItems(): List<ItemEntity>

    @Query("SELECT * FROM items WHERE id = :id")
    suspend fun getItemById(id: String): ItemEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()
}
