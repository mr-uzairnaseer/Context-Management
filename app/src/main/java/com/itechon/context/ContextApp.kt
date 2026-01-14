package com.itechon.context

import android.app.Application
import androidx.room.Room
import com.itechon.context.data.local.AppDatabase
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.ExistingPeriodicWorkPolicy
import java.util.concurrent.TimeUnit
import com.itechon.context.worker.SyncWorker
import com.itechon.context.data.repository.ContextRepository
import com.itechon.context.data.repository.ItemRepository
import com.itechon.context.data.repository.CalendarRepository
import com.itechon.context.data.repository.OCRHelper

class ContextApp : Application() {
    
    lateinit var database: AppDatabase
    lateinit var repository: ContextRepository
    lateinit var itemRepository: ItemRepository
    lateinit var calendarRepository: CalendarRepository
    lateinit var ocrHelper: OCRHelper
    lateinit var audioHelper: com.itechon.context.utils.AudioHelper
    lateinit var locationHelper: com.itechon.context.utils.LocationHelper
    lateinit var userPreferencesRepository: com.itechon.context.data.repository.UserPreferencesRepository

    override fun onCreate() {
        super.onCreate()
        
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "context_db"
        ).fallbackToDestructiveMigration().build()

        repository = ContextRepository(database.contextDao(), database.itemDao())
        itemRepository = ItemRepository(database.itemDao())
        calendarRepository = CalendarRepository(this)
        ocrHelper = OCRHelper(this)
        audioHelper = com.itechon.context.utils.AudioHelper(this)
        locationHelper = com.itechon.context.utils.LocationHelper(this)
        userPreferencesRepository = com.itechon.context.data.repository.UserPreferencesRepository(this)

        // Initialize Coil with SVG support
        val imageLoader = coil.ImageLoader.Builder(this)
            .components {
                add(coil.decode.SvgDecoder.Factory())
            }
            .build()
        coil.Coil.setImageLoader(imageLoader)
        coil.Coil.setImageLoader(imageLoader)

        setupSyncWorker()
    }

    private fun setupSyncWorker() {
        val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "ContextSync",
            ExistingPeriodicWorkPolicy.KEEP,
            syncRequest
        )
    }
}
