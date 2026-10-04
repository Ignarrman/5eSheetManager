package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class MonkData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val monkProgression: List<MonkProgressionEntity>
)

@Entity(
    tableName = "monk_progression",
    primaryKeys = ["level"]
)
data class MonkProgressionEntity(
    val level: Int,
    val martialArtsDie: Int,
    val kiPoints: Int
)
