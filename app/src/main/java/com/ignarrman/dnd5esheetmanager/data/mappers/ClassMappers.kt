package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardData
import com.ignarrman.dnd5esheetmanager.domain.model.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Bard
import com.ignarrman.dnd5esheetmanager.domain.model.classes.BardicInspirationProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.RageProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.CantripProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

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


fun BardData.toDomain(): Bard {

    val featuresById =
        features.associateBy { it.id }

    val featuresByLevel =
        featureRelations
            .map { relation ->
                relation.level to
                        featuresById
                            .getValue(relation.featureId)
                            .toDomain()
            }
            .groupBy(
                keySelector = { it.first },
                valueTransform = { it.second }
            )

    val bardicInspirationByLevel =
        bardicInspirationProgression.associate {
            it.level to BardicInspirationProgression(
                die = it.die
            )
        }

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    return Bard(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        bardicInspiration = bardicInspirationByLevel
    )
}