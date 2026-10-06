package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object MonkReferenceData {

    const val CLASS_ID = 7L
    const val FEATURE_STARTING_ID = 7001L

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-monk.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }

    val progression = (1..20).map { level ->
        MonkProgressionEntity(
            level = level,
            martialArtsDie = when {
                level <= 4 -> 4
                level <= 10 -> 6
                level <= 16 -> 8
                else -> 10
            },
            kiPoints = if (level == 1) 0 else level
        )
    }
}