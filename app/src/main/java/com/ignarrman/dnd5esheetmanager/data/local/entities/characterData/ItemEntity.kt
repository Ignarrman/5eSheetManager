package com.ignarrman.dnd5esheetmanager.data.local.entities.characterData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val name: String,
    val description: String,
    val price: Int,
    val quantity: Int
)
