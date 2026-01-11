package com.itechon.context.data.local

import androidx.room.TypeConverter
import com.itechon.context.data.model.ItemType
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// Simple LatLng class if not available
data class LatLng(val lat: Double, val lng: Double)

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Instant? {
        return value?.let { Instant.fromEpochMilliseconds(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Instant?): Long? {
        return date?.toEpochMilliseconds()
    }
    
    @TypeConverter
    fun fromFloatArray(value: String?): FloatArray? {
        return value?.let { Json.decodeFromString(it) }
    }

    @TypeConverter
    fun floatArrayToString(value: FloatArray?): String? {
        return value?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun fromItemType(value: ItemType): String {
        return value.name
    }

    @TypeConverter
    fun toItemType(value: String): ItemType {
        return ItemType.valueOf(value)
    }
}
