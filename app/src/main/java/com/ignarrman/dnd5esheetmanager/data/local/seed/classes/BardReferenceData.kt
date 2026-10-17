package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedLevelFeature

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

    val spellSlots = fullCasterSpellSlots(CLASS_ID)

    fun getFeatures(
        context: Context
    ): List<ParsedLevelFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-bard.json",
            startingId = FEATURE_STARTING_ID
        )
    }
}