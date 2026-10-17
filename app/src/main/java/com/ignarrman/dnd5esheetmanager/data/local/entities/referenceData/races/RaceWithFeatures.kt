package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class RaceWithFeatures(
    val raceEntity: RaceEntity,
    val features: List<FeatureEntity>
)
