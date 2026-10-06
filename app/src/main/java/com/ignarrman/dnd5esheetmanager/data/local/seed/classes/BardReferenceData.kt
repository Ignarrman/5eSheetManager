package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object BardReferenceData {

    const val CLASS_ID = 2L
    const val FEATURE_STARTING_ID = 2001L

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

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-bard.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }
}