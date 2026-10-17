package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WildShapeProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedLevelFeature

object DruidReferenceData {

    const val CLASS_ID = 5L
    const val FEATURE_STARTING_ID = 5001L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "WIS"
    )

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

    fun getFeatures(
        context: Context
    ): List<ParsedLevelFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-druid.json",
            startingId = FEATURE_STARTING_ID
        )
    }
}