package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ArtificierData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClericData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.DruidData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.PaladinData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.RangerData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.RogueData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SorcererData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WarlockData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WizardData
import com.ignarrman.dnd5esheetmanager.data.local.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Artificer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Bard
import com.ignarrman.dnd5esheetmanager.domain.model.classes.BardicInspirationProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.ChannelDivinityProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Cleric
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Druid
import com.ignarrman.dnd5esheetmanager.domain.model.classes.EldritchInvocation
import com.ignarrman.dnd5esheetmanager.domain.model.classes.EldritchInvocationsKnownProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Fighter
import com.ignarrman.dnd5esheetmanager.domain.model.classes.FighterProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.InfusionProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.LayOnHandsProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Monk
import com.ignarrman.dnd5esheetmanager.domain.model.classes.MonkProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Paladin
import com.ignarrman.dnd5esheetmanager.domain.model.classes.RageProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Ranger
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Rogue
import com.ignarrman.dnd5esheetmanager.domain.model.classes.SneakAttackProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Sorcerer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.SorceryPointProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Warlock
import com.ignarrman.dnd5esheetmanager.domain.model.classes.WildShapeProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Wizard

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

fun ArtificierData.toDomain(): Artificer {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val infusionsByLevel =
        infusionProgression.associate {
            it.level to InfusionProgression(
                known = it.known,
                active = it.active
            )
        }

    return Artificer(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        infusions = infusionsByLevel
    )

}

fun ClericData.toDomain(): Cleric {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val channelDivinityByLevel =
        channelDivinityProgression.associate {
            it.level to ChannelDivinityProgression(
                uses = it.uses
            )
        }

    return Cleric(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        channelDivinity = channelDivinityByLevel
    )

}

fun DruidData.toDomain(): Druid {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val wildShapeByLevel =
        wildShapeProgression.associate {
            it.level to WildShapeProgression(
                maxCr = it.maxCr,
                uses = it.uses
            )
        }

    return Druid(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        wildShape = wildShapeByLevel
    )

}

fun FighterData.toDomain(): Fighter {

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


    val fightingStylesById =
        fightingStyles.associateBy { it.id }

    val fightingStyles =
        fightingStyleCrossRef.map { relation ->
            fightingStylesById
                .getValue(relation.fightingStyleId)
                .toDomain()
        }

    val fighterProgressionByLevel =
        fighterProgression.associate {
            it.level to FighterProgression(
                actionSurgeUses = it.actionSurgeUses,
                indomitableUses = it.indomitableUses
            )
        }

    return Fighter(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        fightingStyles = fightingStyles,
        progression = fighterProgressionByLevel
    )

}

fun MonkData.toDomain(): Monk {

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


    val monkProgressionByLevel =
        monkProgression.associate {
            it.level to MonkProgression(
                martialArtsDie = it.martialArtsDie,
                kiPoints = it.kiPoints
            )
        }

    return Monk(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        martialArtsProgression = monkProgressionByLevel,
    )

}

fun PaladinData.toDomain(): Paladin {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val fightingStylesById =
        fightingStyles.associateBy { it.id }

    val fightingStyles =
        fightingStyleCrossRef.map { relation ->
            fightingStylesById
                .getValue(relation.fightingStyleId)
                .toDomain()
        }

    val layOnHandsByLevel =
        layOnHands.associate {
            it.level to LayOnHandsProgression(
                pool = it.pool
            )
        }

    return Paladin(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        fightingStyles = fightingStyles,
        layOnHands = layOnHandsByLevel
    )

}

fun RangerData.toDomain(): Ranger {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val fightingStylesById =
        fightingStyles.associateBy { it.id }

    val fightingStyles =
        fightingStyleCrossRef.map { relation ->
            fightingStylesById
                .getValue(relation.fightingStyleId)
                .toDomain()
        }

    return Ranger(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        fightingStyles = fightingStyles
    )

}

fun RogueData.toDomain(): Rogue {

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


    val sneakAttackByLevel =
        sneakAttackProgression.associate {
            it.level to SneakAttackProgression(
                dice = it.dice
            )
        }

    return Rogue(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        sneakAttack = sneakAttackByLevel,
    )

}

fun WarlockData.toDomain(): Warlock {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val eldritchInvocations =
        eldritchInvocations.map {
            EldritchInvocation( name = it.name, description = it.description )
        }

    val eldritchInvocationsKnownByLevel =
        eldritchInvocationsKnown.associate {
            it.level to EldritchInvocationsKnownProgression(
                known = it.known
            )
        }

    return Warlock(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        eldritchInvocations = eldritchInvocations,
        eldritchInvocationsKnown = eldritchInvocationsKnownByLevel,
    )

}

fun SorcererData.toDomain(): Sorcerer {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    val sorceryPointProgressionByLevel =
        sorceryPointProgression.associate {
            it.level to SorceryPointProgression(
                points = it.points
            )
        }

    return Sorcerer(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
        sorceryPoints = sorceryPointProgressionByLevel
    )

}

fun WizardData.toDomain(): Wizard {

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

    val spellcastingByLevel = spellcasting.toDomain(
        cantripProgression = cantripProgression,
        spellSlotProgression = spellSlotProgression,
        spellsKnownProgression = spellsKnownProgression
    )

    return Wizard(
        name = classEntity.name,
        hitDice = classEntity.hitDice,
        features = featuresByLevel,
        spellcasting = spellcastingByLevel,
    )

}