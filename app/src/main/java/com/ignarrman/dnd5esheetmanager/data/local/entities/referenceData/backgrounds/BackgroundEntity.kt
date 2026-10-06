package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "backgrounds")
data class BackgroundEntity(
    @PrimaryKey
    val name: String,
    val skillProficiencies: String,
    val languages: String?,
    val equipment: String?,
    val featureName: String,
    val featureDescription: String
)