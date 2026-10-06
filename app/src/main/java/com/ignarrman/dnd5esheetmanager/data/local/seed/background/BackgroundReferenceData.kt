package com.ignarrman.dnd5esheetmanager.data.local.seed.background

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundEntity
import org.json.JSONArray


fun getBackgrounds(
    context: Context
): List<ParsedBackground> {

    return BackgroundJsonParser.parse(
        context = context,
        fileName = "backgrounds.json"
    )
}

suspend fun insertBackgroundReferenceData(
    database: AppDatabase,
    context: Context
) {
    val parsedBackgrounds = getBackgrounds(context)

    val backgroundEntities = parsedBackgrounds.map {
        BackgroundEntity(
            name = it.name,
            skillProficiencies = JSONArray(it.skillProficiencies).toString(),
            languages = it.languages,
            equipment = it.equipment,
            featureName = it.featureName,
            featureDescription = it.featureDescription
        )
    }

    database.backgroundDao().insertAll(backgroundEntities)
}

suspend fun clearBackgroundReferenceData(
    database: AppDatabase
){
    database.backgroundDao().deleteAll()
}