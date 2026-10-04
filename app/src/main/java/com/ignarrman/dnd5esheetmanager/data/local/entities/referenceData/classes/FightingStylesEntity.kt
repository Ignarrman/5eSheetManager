package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fighting_styles")
data class FightingStyleEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String
)
