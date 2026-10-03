package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.RageProgression

fun BarbarianData.toDomain(): Barbarian {

    val featuresById = features.associateBy { it.id }

    val featuresByLevel =
        featureRelations
            .map { relation -> relation.level to featuresById.getValue(relation.featureId).toDomain() }
            .groupBy(keySelector = { it.first }, valueTransform = { it.second })

    val rageProgressionByLevel =
        progression.associate {
            it.level to RageProgression(
                charges = it.rageUses,
                damageBonus = it.rageDamage
            )
        }

    return Barbarian(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        rage = rageProgressionByLevel
    )
}