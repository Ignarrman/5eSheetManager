package com.ignarrman.dnd5esheetmanager.data.local.seed.races

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceFeatureCrossRef

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
            source = race.source
        )
    }
    val featureRelations = mutableListOf<RaceFeatureCrossRef>()
    val featureEntities = mutableListOf<FeatureEntity>()

    races.forEach { race ->

        race.features.forEach { feature ->

            featureEntities += FeatureEntity(
                id = feature.id,
                name = feature.name,
                description = feature.description
            )

            featureRelations += RaceFeatureCrossRef(
                raceId = race.id,
                featureId = feature.id
            )
        }
    }

    database.featureDao().insertAll(featureEntities)
    database.raceDao().insertAll(raceEntities)
    database.raceDao().insertFeatureRelations(featureRelations)
}

suspend fun clearRaceReferenceData(
    database: AppDatabase
) {
    database.raceDao().deleteAll()
}