package com.itechon.context.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Entity(tableName = "contexts")
@Serializable
data class ContextEntity(
    @PrimaryKey val id: String, // UUID as String
    val title: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val confidenceScore: Float = 1.0f,
    val startTime: Instant? = null,
    val endTime: Instant? = null,
    val primaryLocationLat: Double? = null,
    val primaryLocationLng: Double? = null,
    val isUserCreated: Boolean = true,
    val embedding: FloatArray? = null,
    val syncStatus: String = "SYNCED" // SYNCED, DIRTY, DELETED
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ContextEntity

        if (id != other.id) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}
