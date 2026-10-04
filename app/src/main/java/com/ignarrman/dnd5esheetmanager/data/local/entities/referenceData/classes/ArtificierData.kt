package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

data class ArtificierData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val spellcasting: SpellcastingEntity,
    val cantripProgression: List<CantripProgressionEntity>,
    val spellSlotProgression: List<SpellSlotProgressionEntity>,
    val spellsKnownProgression: List<SpellsKnownProgressionEntity>,
    val infusionProgression: List<InfusionProgressionEntity>
)

@Entity(
    tableName = "infusion_progression",
    primaryKeys = ["level"]
)
data class InfusionProgressionEntity(
    val level: Int,
    val known: Int,
    val active: Int
)
