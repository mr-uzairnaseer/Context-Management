package com.itechon.context

import android.app.Application
import androidx.room.Room
import com.itechon.context.data.local.AppDatabase
import com.itechon.context.data.repository.ContextRepository

class ContextApp : Application() {
    
    lateinit var database: AppDatabase
    lateinit var repository: ContextRepository

    override fun onCreate() {
        super.onCreate()
        
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "context_db"
        ).build()

        repository = ContextRepository(database.contextDao(), database.itemDao())
    }
}
