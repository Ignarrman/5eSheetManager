package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity

data class PaladinData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val fightingStyleCrossRef: List<ClassFightingStyleCrossRef>,
    val fightingStyles: List<FightingStyleEntity>,
    val spellcasting: SpellcastingEntity,
    val spellSlotProgression: List<SpellSlotProgressionEntity>,
    val layOnHands: List<LayOnHandsProgressionEntity>
)

@Entity(
    tableName = "lay_on_hands_progression",
    primaryKeys = ["level"]
)
data class LayOnHandsProgressionEntity(
    val level: Int,
    val pool: Int
)
