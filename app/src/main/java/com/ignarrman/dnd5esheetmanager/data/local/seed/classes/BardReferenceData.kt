package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object BardReferenceData {

    const val CLASS_ID = 2L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "CHA"
    )

    val bardicInspiration = listOf(
        BardicInspirationProgressionEntity(1, 6),
        BardicInspirationProgressionEntity(2, 6),
        BardicInspirationProgressionEntity(3, 6),
        BardicInspirationProgressionEntity(4, 6),
        BardicInspirationProgressionEntity(5, 8),
        BardicInspirationProgressionEntity(6, 8),
        BardicInspirationProgressionEntity(7, 8),
        BardicInspirationProgressionEntity(8, 8),
        BardicInspirationProgressionEntity(9, 8),
        BardicInspirationProgressionEntity(10, 10),
        BardicInspirationProgressionEntity(11, 10),
        BardicInspirationProgressionEntity(12, 10),
        BardicInspirationProgressionEntity(13, 10),
        BardicInspirationProgressionEntity(14, 10),
        BardicInspirationProgressionEntity(15, 10),
        BardicInspirationProgressionEntity(16, 10),
        BardicInspirationProgressionEntity(17, 12),
        BardicInspirationProgressionEntity(18, 12),
        BardicInspirationProgressionEntity(19, 12),
        BardicInspirationProgressionEntity(20, 12)
    )

    val cantrips = listOf(
        CantripProgressionEntity(CLASS_ID, 1, 2),
        CantripProgressionEntity(CLASS_ID, 2, 2),
        CantripProgressionEntity(CLASS_ID, 3, 2),
        CantripProgressionEntity(CLASS_ID, 4, 2),
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

    val spellsKnown = listOf(
        SpellsKnownProgressionEntity(CLASS_ID, 1, 4),
        SpellsKnownProgressionEntity(CLASS_ID, 2, 5),
        SpellsKnownProgressionEntity(CLASS_ID, 3, 6),
        SpellsKnownProgressionEntity(CLASS_ID, 4, 7),
        SpellsKnownProgressionEntity(CLASS_ID, 5, 8),
        SpellsKnownProgressionEntity(CLASS_ID, 6, 9),
        SpellsKnownProgressionEntity(CLASS_ID, 7, 10),
        SpellsKnownProgressionEntity(CLASS_ID, 8, 11),
        SpellsKnownProgressionEntity(CLASS_ID, 9, 12),
        SpellsKnownProgressionEntity(CLASS_ID, 10, 14),
        SpellsKnownProgressionEntity(CLASS_ID, 11, 15),
        SpellsKnownProgressionEntity(CLASS_ID, 12, 15),
        SpellsKnownProgressionEntity(CLASS_ID, 13, 16),
        SpellsKnownProgressionEntity(CLASS_ID, 14, 18),
        SpellsKnownProgressionEntity(CLASS_ID, 15, 19),
        SpellsKnownProgressionEntity(CLASS_ID, 16, 19),
        SpellsKnownProgressionEntity(CLASS_ID, 17, 20),
        SpellsKnownProgressionEntity(CLASS_ID, 18, 22),
        SpellsKnownProgressionEntity(CLASS_ID, 19, 22),
        SpellsKnownProgressionEntity(CLASS_ID, 20, 22)
    )

    val spellSlots = listOf(
        // Level 1
        SpellSlotProgressionEntity(CLASS_ID, 1, 1, 2),

        // Level 2
        SpellSlotProgressionEntity(CLASS_ID, 2, 1, 3),

        // Level 3
        SpellSlotProgressionEntity(CLASS_ID, 3, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 3, 2, 2),

        // Level 4
        SpellSlotProgressionEntity(CLASS_ID, 4, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 4, 2, 3),

        // Level 5
        SpellSlotProgressionEntity(CLASS_ID, 5, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 5, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 5, 3, 2),

        // Level 6
        SpellSlotProgressionEntity(CLASS_ID, 6, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 6, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 6, 3, 3),

        // Level 7
        SpellSlotProgressionEntity(CLASS_ID, 7, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 7, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 4, 1),

        // Level 8
        SpellSlotProgressionEntity(CLASS_ID, 8, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 8, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 4, 2),

        // Level 9
        SpellSlotProgressionEntity(CLASS_ID, 9, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 9, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 5, 1),

        // Level 10
        SpellSlotProgressionEntity(CLASS_ID, 10, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 10, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 5, 2),

        // Level 11
        SpellSlotProgressionEntity(CLASS_ID, 11, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 11, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 11, 6, 1),

        // Level 12
        SpellSlotProgressionEntity(CLASS_ID, 12, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 12, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 12, 6, 1),

        // Level 13
        SpellSlotProgressionEntity(CLASS_ID, 13, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 13, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 13, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 13, 7, 1),

        // Level 14
        SpellSlotProgressionEntity(CLASS_ID, 14, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 14, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 14, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 14, 7, 1),

        // Level 15
        SpellSlotProgressionEntity(CLASS_ID, 15, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 15, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 15, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 8, 1),

        // Level 16
        SpellSlotProgressionEntity(CLASS_ID, 16, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 16, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 16, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 8, 1),

        // Level 17
        SpellSlotProgressionEntity(CLASS_ID, 17, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 17, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 17, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 9, 1),

        // Level 18
        SpellSlotProgressionEntity(CLASS_ID, 18, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 18, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 18, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 9, 1),

        // Level 19
        SpellSlotProgressionEntity(CLASS_ID, 19, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 19, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 19, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 9, 1),

        // Level 20
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

    val features = listOf(
        FeatureEntity(
            id = 2001L,
            name = "Spellcasting",
            description = "Allows the bard to cast spells using Charisma as the spellcasting ability."
        ),
        FeatureEntity(
            id = 2002L,
            name = "Bardic Inspiration",
            description = "Allows the bard to inspire another creature with a Bardic Inspiration die."
        ),
        FeatureEntity(
            id = 2003L,
            name = "Jack of All Trades",
            description = "Adds part of the bard's proficiency bonus to ability checks that do not already use it."
        ),
        FeatureEntity(
            id = 2004L,
            name = "Song of Rest",
            description = "Improves the amount of healing received during a short rest."
        ),
        FeatureEntity(
            id = 2005L,
            name = "Expertise",
            description = "Doubles the proficiency bonus for selected proficient skills."
        ),
        FeatureEntity(
            id = 2006L,
            name = "Font of Inspiration",
            description = "Allows Bardic Inspiration to be recovered on a short rest."
        ),
        FeatureEntity(
            id = 2007L,
            name = "Countercharm",
            description = "Allows the bard to help nearby creatures resist certain charm and fear effects."
        ),
        FeatureEntity(
            id = 2008L,
            name = "Magical Secrets",
            description = "Allows the bard to learn selected spells from outside the bard spell list."
        ),
        FeatureEntity(
            id = 2009L,
            name = "Superior Inspiration",
            description = "Restores Bardic Inspiration when the bard begins an encounter without any uses remaining."
        )
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2001L,
            level = 1
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2002L,
            level = 1
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2003L,
            level = 2
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2004L,
            level = 2
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2005L,
            level = 3
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2006L,
            level = 5
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2007L,
            level = 6
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2008L,
            level = 10
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 2009L,
            level = 20
        )
    )
}