package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.domain.model.Feature

fun FeatureEntity.toDomain(): Feature = Feature(name = name, description = description)

