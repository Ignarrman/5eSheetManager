package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.classes.FightingStyle

fun FeatureEntity.toDomain(): Feature =
    Feature(
        name = name,
        description = description
    )


fun FightingStyleEntity.toDomain(): FightingStyle =
    FightingStyle(
        name = name,
        description = description
    )


