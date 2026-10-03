package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity


data class BardData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val bardicInspirationProgression: List<BardicInspirationProgressionEntity>,
    val spellcasting: SpellcastingEntity,
    val cantripProgression: List<CantripProgressionEntity>,
    val spellSlotProgression: List<SpellSlotProgressionEntity>,
    val spellsKnownProgression: List<SpellsKnownProgressionEntity>
)

@Entity(
    tableName = "bardic_inspiration_progression",
    primaryKeys = ["level"]
)
data class BardicInspirationProgressionEntity(
    val level: Int,
    val die: Int
)