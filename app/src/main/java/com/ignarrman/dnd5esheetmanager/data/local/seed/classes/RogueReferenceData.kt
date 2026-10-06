package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SneakAttackProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object RogueReferenceData {

    const val CLASS_ID = 10L
    const val FEATURE_STARTING_ID = 10001L

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-rogue.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }

    val sneakAttackProgression = (1..20).map { level ->
        SneakAttackProgressionEntity(
            level = level,
            dice = (level + 1) / 2
        )
    }
}