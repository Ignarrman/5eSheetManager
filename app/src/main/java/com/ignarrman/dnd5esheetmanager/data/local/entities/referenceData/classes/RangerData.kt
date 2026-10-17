package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity

data class RangerData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val fightingStyleCrossRef: List<ClassFightingStyleCrossRef>,
    val fightingStyles: List<FightingStyleEntity>,
    val spellcasting: SpellcastingEntity,
    val spellSlotProgression: List<SpellSlotProgressionEntity>,
)
