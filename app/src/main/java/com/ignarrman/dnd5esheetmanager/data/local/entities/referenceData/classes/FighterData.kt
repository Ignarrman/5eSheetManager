package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class FighterData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val fightingStyleCrossRef: List<ClassFightingStyleCrossRef>,
    val fightingStyles: List<FightingStyleEntity>,
    val fighterProgression: List<FighterProgressionEntity>
)

@Entity(
    tableName = "fighter_progression",
    primaryKeys = ["level"]
)
data class FighterProgressionEntity(
    val level: Int,
    val actionSurgeUses: Int,
    val indomitableUses: Int
)
