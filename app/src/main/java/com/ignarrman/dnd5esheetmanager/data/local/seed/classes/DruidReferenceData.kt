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

    val spellSlots = listOf(
        SpellSlotProgressionEntity(CLASS_ID, 1, 1, 2),

        SpellSlotProgressionEntity(CLASS_ID, 2, 1, 3),

        SpellSlotProgressionEntity(CLASS_ID, 3, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 3, 2, 2),

        SpellSlotProgressionEntity(CLASS_ID, 4, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 4, 2, 3),

        SpellSlotProgressionEntity(CLASS_ID, 5, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 5, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 5, 3, 2),

        SpellSlotProgressionEntity(CLASS_ID, 6, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 6, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 6, 3, 3),

        SpellSlotProgressionEntity(CLASS_ID, 7, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 7, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 4, 1),

        SpellSlotProgressionEntity(CLASS_ID, 8, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 8, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 4, 2),

        SpellSlotProgressionEntity(CLASS_ID, 9, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 9, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 5, 1),

        SpellSlotProgressionEntity(CLASS_ID, 10, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 10, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 5, 2),

        SpellSlotProgressionEntity(CLASS_ID, 11, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 11, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 11, 6, 1),

        SpellSlotProgressionEntity(CLASS_ID, 12, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 12, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 12, 6, 1),

        SpellSlotProgressionEntity(CLASS_ID, 13, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 13, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 13, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 13, 7, 1),

        SpellSlotProgressionEntity(CLASS_ID, 14, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 14, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 14, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 14, 7, 1),

        SpellSlotProgressionEntity(CLASS_ID, 15, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 15, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 15, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 8, 1),

        SpellSlotProgressionEntity(CLASS_ID, 16, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 16, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 16, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 8, 1),

        SpellSlotProgressionEntity(CLASS_ID, 17, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 17, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 17, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 18, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 18, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 18, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 19, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 19, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 19, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 20, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 20, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 20, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 9, 1)
    )

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