package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class RogueData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val sneakAttackProgression: List<SneakAttackProgressionEntity>
)

@Entity(
    tableName = "sneak_attack_progression",
    primaryKeys = ["level"]
)
data class SneakAttackProgressionEntity(
    val level: Int,
    val dice: Int
)
