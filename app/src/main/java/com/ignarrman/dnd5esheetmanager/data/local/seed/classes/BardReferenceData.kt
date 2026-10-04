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

    val spellSlots = fullCasterSpellSlots(CLASS_ID)

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