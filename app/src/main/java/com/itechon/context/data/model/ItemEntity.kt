package com.itechon.context.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

enum class ItemType {
    NOTE, PHOTO, AUDIO, LOCATION, TASK
}

@Entity(tableName = "items")
@Serializable
data class ItemEntity(
    @PrimaryKey val id: String, // UUID as String
    val type: ItemType,
    val content: String? = null,
    val mediaUri: String? = null,
    val timestamp: Instant,
    val locationLat: Double? = null,
    val locationLng: Double? = null,
    val contextId: String? = null, // Foreign Key to Context
    val embedding: FloatArray? = null,
    val syncStatus: String = "SYNCED", // SYNCED, DIRTY, DELETED
    val isCompleted: Boolean = false
) {
     override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemEntity

        if (id != other.id) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}
