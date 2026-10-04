package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WildShapeProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object DruidReferenceData {

    const val CLASS_ID = 5L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "WIS"
    )

    val cantrips = listOf(
        CantripProgressionEntity(CLASS_ID, 1, 2),
        CantripProgressionEntity(CLASS_ID, 2, 2),
        CantripProgressionEntity(CLASS_ID, 3, 2),
        CantripProgressionEntity(CLASS_ID, 4, 3),
        CantripProgressionEntity(CLASS_ID, 5, 3),
        CantripProgressionEntity(CLASS_ID, 6, 3),
        CantripProgressionEntity(CLASS_ID, 7, 3),
        CantripProgressionEntity(CLASS_ID, 8, 3),
        CantripProgressionEntity(CLASS_ID, 9, 3),
        CantripProgressionEntity(CLASS_ID, 10, 4),
        CantripProgressionEntity(CLASS_ID, 11, 4),
        CantripProgressionEntity(CLASS_ID, 12, 4),
        CantripProgressionEntity(CLASS_ID, 13, 4),
        CantripProgressionEntity(CLASS_ID, 14, 4),
        CantripProgressionEntity(CLASS_ID, 15, 4),
        CantripProgressionEntity(CLASS_ID, 16, 4),
        CantripProgressionEntity(CLASS_ID, 17, 4),
        CantripProgressionEntity(CLASS_ID, 18, 4),
        CantripProgressionEntity(CLASS_ID, 19, 4),
        CantripProgressionEntity(CLASS_ID, 20, 4)
    )

    val spellsKnown = emptyList<SpellsKnownProgressionEntity>()

    val spellSlots = fullCasterSpellSlots(CLASS_ID)

    val wildShapeProgression = listOf(
        WildShapeProgressionEntity(2, "1/4", 2),
        WildShapeProgressionEntity(3, "1/2", 2),
        WildShapeProgressionEntity(4, "1", 2),
        WildShapeProgressionEntity(5, "1", 2),
        WildShapeProgressionEntity(6, "1", 2),
        WildShapeProgressionEntity(7, "2", 2),
        WildShapeProgressionEntity(8, "2", 2),
        WildShapeProgressionEntity(9, "3", 2),
        WildShapeProgressionEntity(10, "3", 2),
        WildShapeProgressionEntity(11, "3", 2),
        WildShapeProgressionEntity(12, "3", 2),
        WildShapeProgressionEntity(13, "3", 2),
        WildShapeProgressionEntity(14, "3", 2),
        WildShapeProgressionEntity(15, "3", 2),
        WildShapeProgressionEntity(16, "3", 2),
        WildShapeProgressionEntity(17, "4", 2),
        WildShapeProgressionEntity(18, "4", 2),
        WildShapeProgressionEntity(19, "4", 2),
        WildShapeProgressionEntity(20, "4", 2)
    )

    val features = listOf(
        FeatureEntity(5001L, "Druidic", "Grants the druid knowledge of the Druidic language and its secret written signs."),
        FeatureEntity(5002L, "Spellcasting", "Allows the druid to cast spells using Wisdom as the spellcasting ability."),
        FeatureEntity(5003L, "Wild Shape", "Allows the druid to assume the form of a beast under the normal Wild Shape limitations."),
        FeatureEntity(5004L, "Ability Score Improvement", "Allows the druid to improve ability scores or select a feat."),
        FeatureEntity(5005L, "Timeless Body", "Reduces the physical effects of aging on the druid."),
        FeatureEntity(5006L, "Beast Spells", "Allows the druid to cast spells while using Wild Shape."),
        FeatureEntity(5007L, "Archdruid", "Removes most restrictions on Wild Shape and improves the druid's ability to use it repeatedly.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 5001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 5002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 5003L, 2),
        ClassFeatureCrossRef(CLASS_ID, 5004L, 4),
        ClassFeatureCrossRef(CLASS_ID, 5004L, 8),
        ClassFeatureCrossRef(CLASS_ID, 5004L, 12),
        ClassFeatureCrossRef(CLASS_ID, 5004L, 16),
        ClassFeatureCrossRef(CLASS_ID, 5005L, 18),
        ClassFeatureCrossRef(CLASS_ID, 5006L, 18),
        ClassFeatureCrossRef(CLASS_ID, 5007L, 20)
    )
}