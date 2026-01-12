package com.itechon.context

import android.app.Application
import androidx.room.Room
import com.itechon.context.data.local.AppDatabase
import com.itechon.context.data.repository.ContextRepository
import com.itechon.context.data.repository.ItemRepository

class ContextApp : Application() {
    
    lateinit var database: AppDatabase
    lateinit var repository: ContextRepository
    lateinit var itemRepository: ItemRepository

    override fun onCreate() {
        super.onCreate()
        
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "context_db"
        ).build()

        repository = ContextRepository(database.contextDao(), database.itemDao())
        itemRepository = ItemRepository(database.itemDao())

        // Initialize Coil with SVG support
        val imageLoader = coil.ImageLoader.Builder(this)
            .components {
                add(coil.decode.SvgDecoder.Factory())
            }
            .build()
        coil.Coil.setImageLoader(imageLoader)
    }
}
