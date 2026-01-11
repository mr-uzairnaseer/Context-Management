package com.itechon.context.data.local

import androidx.room.*
import com.itechon.context.data.model.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM items WHERE contextId = :contextId ORDER BY timestamp DESC")
    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE syncStatus = 'DIRTY'")
    suspend fun getDirtyItems(): List<ItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)
}
