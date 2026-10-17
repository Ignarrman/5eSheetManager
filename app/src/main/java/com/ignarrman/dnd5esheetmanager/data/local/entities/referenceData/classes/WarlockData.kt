package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity

data class WarlockData(
    val classEntity: ClassEntity,
    val featureRelations: List<ClassFeatureCrossRef>,
    val features: List<FeatureEntity>,
    val spellcasting: SpellcastingEntity,
    val spellSlotProgression: List<SpellSlotProgressionEntity>,
    val eldritchInvocations: List<EldritchInvocationsEntity>,
    val eldritchInvocationsKnown: List<EldritchInvocationsKnownProgressionEntity>
)

@Entity(
    tableName = "eldritch_invocations_progression",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class EldritchInvocationsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val level: Int,
    val name: String,
    val description: String
)

@Entity(
    tableName = "eldritch_invocations_known_progression",
    primaryKeys = ["level"]
)
data class EldritchInvocationsKnownProgressionEntity(
    val level: Int,
    val known: Int
)
