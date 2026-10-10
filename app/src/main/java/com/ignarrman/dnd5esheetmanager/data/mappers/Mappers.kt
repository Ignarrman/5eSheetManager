package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.classes.FightingStyle
import org.json.JSONArray

fun FeatureEntity.toDomain(): Feature =
    Feature(
        id = id,
        name = name,
        description = description
    )


fun FightingStyleEntity.toDomain(): FightingStyle =
    FightingStyle(
        id = id,
        name = name,
        description = description
    )

fun BackgroundEntity.toDomain(): Background {
    return Background(
        id = id,
        name = name,
        skillProficiencies = JSONArray(skillProficiencies).let { json ->
            List(json.length()) { index ->
                json.getString(index)
            }
        },
        languages = languages,
        equipment = equipment,
        featureId = id
    )
}

