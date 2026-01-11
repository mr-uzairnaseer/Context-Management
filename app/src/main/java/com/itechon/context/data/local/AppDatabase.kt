package com.itechon.context.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity

@Database(entities = [ContextEntity::class, ItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contextDao(): ContextDao
    abstract fun itemDao(): ItemDao
}
