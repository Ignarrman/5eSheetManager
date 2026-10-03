package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "features")
data class FeatureEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String
)
