package com.itechon.context.data.repository

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.CalendarContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Calendar

data class CalendarInfo(
    val id: Long,
    val displayName: String,
    val accountName: String,
    val color: Int
)

data class CalendarEvent(
    val id: Long,
    val title: String,
    val description: String?,
    val startTime: Long,
    val endTime: Long,
    val location: String?
)

class CalendarRepository(private val context: Context) {

    suspend fun getAvailableCalendars(): List<CalendarInfo> = withContext(Dispatchers.IO) {
        val calendars = mutableListOf<CalendarInfo>()
        val uri: Uri = CalendarContract.Calendars.CONTENT_URI
        val projection = arrayOf(
            CalendarContract.Calendars._ID,
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
            CalendarContract.Calendars.ACCOUNT_NAME,
            CalendarContract.Calendars.CALENDAR_COLOR
        )

        // Only query valid calendars (synced and visible is optional but good practice)
        val selection = null // "${CalendarContract.Calendars.VISIBLE} = 1"
        val selectionArgs = null
        
        try {
            val cursor: Cursor? = context.contentResolver.query(
                uri,
                projection,
                selection,
                selectionArgs,
                null
            )

            cursor?.use {
                val idIndex = it.getColumnIndex(CalendarContract.Calendars._ID)
                val nameIndex = it.getColumnIndex(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME)
                val accountIndex = it.getColumnIndex(CalendarContract.Calendars.ACCOUNT_NAME)
                val colorIndex = it.getColumnIndex(CalendarContract.Calendars.CALENDAR_COLOR)

                while (it.moveToNext()) {
                    val id = it.getLong(idIndex)
                    val displayName = it.getString(nameIndex) ?: "Unknown"
                    val accountName = it.getString(accountIndex) ?: ""
                    val color = it.getInt(colorIndex)
                    calendars.add(CalendarInfo(id, displayName, accountName, color))
                }
            }
        } catch (e: SecurityException) {
            // Permission might not be granted yet
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return@withContext calendars
    }

    suspend fun getTodayEvents(calendarId: Long): List<CalendarEvent> = withContext(Dispatchers.IO) {
        val events = mutableListOf<CalendarEvent>()
        
        val startOfDay = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        
        val endOfDay = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }

        val uri: Uri = CalendarContract.Instances.CONTENT_URI
        val builder = uri.buildUpon()
        android.content.ContentUris.appendId(builder, startOfDay.timeInMillis)
        android.content.ContentUris.appendId(builder, endOfDay.timeInMillis)

        val projection = arrayOf(
            CalendarContract.Instances.EVENT_ID,
            CalendarContract.Instances.TITLE,
            CalendarContract.Instances.DESCRIPTION,
            CalendarContract.Instances.BEGIN,
            CalendarContract.Instances.END,
            CalendarContract.Instances.EVENT_LOCATION
        )

        val selection = "${CalendarContract.Instances.CALENDAR_ID} = ?"
        val selectionArgs = arrayOf(calendarId.toString())
        
        try {
            val cursor: Cursor? = context.contentResolver.query(
                builder.build(),
                projection,
                selection,
                selectionArgs,
                CalendarContract.Instances.BEGIN + " ASC"
            )

            cursor?.use {
                val idIndex = it.getColumnIndex(CalendarContract.Instances.EVENT_ID)
                val titleIndex = it.getColumnIndex(CalendarContract.Instances.TITLE)
                val descIndex = it.getColumnIndex(CalendarContract.Instances.DESCRIPTION)
                val beginIndex = it.getColumnIndex(CalendarContract.Instances.BEGIN)
                val endIndex = it.getColumnIndex(CalendarContract.Instances.END)
                val locIndex = it.getColumnIndex(CalendarContract.Instances.EVENT_LOCATION)

                while (it.moveToNext()) {
                    val id = it.getLong(idIndex)
                    val title = it.getString(titleIndex) ?: "No Title"
                    val desc = it.getString(descIndex)
                    val begin = it.getLong(beginIndex)
                    val end = it.getLong(endIndex)
                    val location = it.getString(locIndex)
                    
                    events.add(CalendarEvent(id, title, desc, begin, end, location))
                }
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

        return@withContext events
    }
}
