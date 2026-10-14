package com.ignarrman.dnd5esheetmanager.data.local.seed.races

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceEntity
import org.json.JSONArray

private const val RACE_STARTING_ID = 1L
private const val RACE_FEATURE_STARTING_ID = 14001L

fun getRaces(context: Context): List<ParsedRace> {
    return RaceJsonParser.parse(
        context = context,
        fileName = "races.json",
        startingId = RACE_STARTING_ID,
        featureStartingId = RACE_FEATURE_STARTING_ID
    )
}

suspend fun insertRaceReferenceData(
    database: AppDatabase,
    context: Context
) {
    val races = getRaces(context)

    val raceEntities = races.map { race ->
        RaceEntity(
            id = race.id,
            name = race.name,
            size = race.size,
            landSpeed = race.landSpeed,
            swimSpeed = race.swimSpeed,
            climbSpeed = race.climbSpeed,
            flySpeed = race.flySpeed,
            featureIds = JSONArray(race.featureIds).toString(),
            source = race.source
        )
    }

    val featureEntities = races
        .flatMap { it.features }
        .map { feature ->
            FeatureEntity(
                id = feature.id,
                name = feature.name,
                description = feature.description
            )
        }

    database.featureDao().insertAll(featureEntities)
    database.raceDao().insertAll(raceEntities)
}

suspend fun clearRaceReferenceData(
    database: AppDatabase
) {
    database.raceDao().deleteAll()
}