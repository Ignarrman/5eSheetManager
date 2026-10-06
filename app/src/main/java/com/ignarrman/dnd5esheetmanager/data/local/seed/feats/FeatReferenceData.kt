package com.ignarrman.dnd5esheetmanager.data.local.seed.feats

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity

private const val FEAT_STARTING_ID = 1L

fun getFeats(
    context: Context
): List<ParsedFeat> {

    return FeatJsonParser.parse(
        context = context,
        fileName = "feats.json",
        startingId = FEAT_STARTING_ID
    )
}


suspend fun insertFeatReferenceData(
    database: AppDatabase,
    context: Context
) {

    val feats = getFeats(context)

    database.featDao().insertAll(
        feats.map {
            FeatEntity(
                id = it.id,
                name = it.name,
                description = it.description,
                prerequisite = it.prerequisite,
                abilityBonus = it.abilityBonus
            )
        }
    )
}

suspend fun clearFeatReferenceData(
    database: AppDatabase
) {
    database.featDao().deleteAll()
}