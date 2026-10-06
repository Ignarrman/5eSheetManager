package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat

fun FeatEntity.toDomain(): Feat {
    return Feat(
        name = name,
        description = description,
        prerequisite = prerequisite,
        abilityBonus = abilityBonus
    )
}