package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object BarbarianReferenceData {

    const val CLASS_ID = 1L
    const val FEATURE_STARTING_ID = 1001L

    val progression = listOf(
        BarbarianProgressionEntity(
            level = 1,
            rageUses = 2,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 2,
            rageUses = 2,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 3,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 4,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 5,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 6,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 7,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 8,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 9,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 10,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 11,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 12,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 13,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 14,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 15,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 16,
            rageUses = 5,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 17,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 18,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 19,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 20,
            rageUses = 999,
            rageDamage = 4
        )
    )

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-barbarian.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }
}