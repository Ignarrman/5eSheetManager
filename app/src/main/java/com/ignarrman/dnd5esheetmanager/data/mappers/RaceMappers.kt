package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceEntity
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.races.Size
import com.ignarrman.dnd5esheetmanager.domain.model.races.Speed

fun RaceEntity.toDomain(
    features: List<FeatureEntity>
): Race {
    return Race(
        id = id,
        name = name,
        size = when (size.uppercase()) {
            "SMALL" -> Size.SMALL
            "MEDIUM" -> Size.MEDIUM
            "LARGE" -> Size.LARGE
            else -> Size.MEDIUM
        },
        speed = Speed(
            land = landSpeed,
            swim = swimSpeed,
            climb = climbSpeed,
            fly = flySpeed
        ),
        features = features.map {
            Feature(
                id = id,
                name = it.name,
                description = it.description
            )
        },
        source = source
    )
}