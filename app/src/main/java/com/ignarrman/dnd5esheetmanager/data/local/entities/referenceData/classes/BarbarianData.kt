package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class BarbarianData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val progression: List<BarbarianProgressionEntity>
)

@Entity(
    tableName = "barbarian_progression",
    primaryKeys = ["level"]
)
data class BarbarianProgressionEntity(
    val level: Int,
    val rageUses: Int,
    val rageDamage: Int
)
