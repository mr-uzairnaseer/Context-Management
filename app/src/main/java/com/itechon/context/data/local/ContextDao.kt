package com.itechon.context.data.local

import androidx.room.*
import com.itechon.context.data.model.ContextEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContextDao {
    @Query("SELECT * FROM contexts WHERE syncStatus != 'DELETED' ORDER BY updatedAt DESC")
    fun getAllContexts(): Flow<List<ContextEntity>>

    @Query("SELECT * FROM contexts WHERE id = :id")
    suspend fun getContextById(id: String): ContextEntity?

    @Query("SELECT * FROM contexts WHERE syncStatus = 'DIRTY'")
    suspend fun getDirtyContexts(): List<ContextEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContext(context: ContextEntity)

    @Delete
    suspend fun deleteContext(context: ContextEntity)
    
    @Query("DELETE FROM contexts WHERE id = :id")
    suspend fun deleteContextById(id: String)

    @Query("DELETE FROM contexts")
    suspend fun deleteAllContexts()
}
