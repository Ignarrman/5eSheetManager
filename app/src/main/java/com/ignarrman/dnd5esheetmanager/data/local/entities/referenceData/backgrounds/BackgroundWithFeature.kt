package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

data class BackgroundWithFeature(
    val background: BackgroundEntity,
    val feature: FeatureEntity
)
