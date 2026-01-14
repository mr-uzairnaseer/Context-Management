package com.itechon.context.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BackupData(
    val version: Int = 1,
    val timestamp: Long,
    val contexts: List<ContextBackup>,
    val items: List<ItemBackup>
)

@Serializable
data class ContextBackup(
    val id: String,
    val title: String,
    val createdAt: Long,
    val updatedAt: Long,
    val isPinned: Boolean,
    val color: Int?
)

@Serializable
data class ItemBackup(
    val id: String,
    val contextId: String,
    val type: String,
    val content: String?,
    val mediaUri: String?,
    val timestamp: Long,
    val isCompleted: Boolean
)
