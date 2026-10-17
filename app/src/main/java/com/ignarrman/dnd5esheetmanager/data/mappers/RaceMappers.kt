package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceWithFeatures
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.races.Size
import com.ignarrman.dnd5esheetmanager.domain.model.races.Speed

fun RaceWithFeatures.toDomain(
): Race {
    return Race(
        id = raceEntity.id,
        name = raceEntity.name,
        size = when (raceEntity.size.uppercase()) {
            "SMALL" -> Size.SMALL
            "MEDIUM" -> Size.MEDIUM
            "LARGE" -> Size.LARGE
            else -> Size.MEDIUM
        },
        speed = Speed(
            land = raceEntity.landSpeed,
            swim = raceEntity.swimSpeed,
            climb = raceEntity.climbSpeed,
            fly = raceEntity.flySpeed
        ),
        features = features.map { it.toDomain() },
        source = raceEntity.source
    )
}