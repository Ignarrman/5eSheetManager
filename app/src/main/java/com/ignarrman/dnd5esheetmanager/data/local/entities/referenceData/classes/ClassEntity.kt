package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

@Entity(tableName = "classes")
data class ClassEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val hitDice: Int
)
