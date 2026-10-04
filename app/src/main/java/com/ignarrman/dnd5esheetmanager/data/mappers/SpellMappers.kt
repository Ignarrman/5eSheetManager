package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.domain.model.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.spells.CantripProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellComponents
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSchool
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

fun SpellcastingEntity.toDomain(
    cantripProgression: List<CantripProgressionEntity>,
    spellSlotProgression: List<SpellSlotProgressionEntity>,
    spellsKnownProgression: List<SpellsKnownProgressionEntity>
): Spellcasting {

    val cantripsByLevel =
        cantripProgression.associate {
            it.level to CantripProgression(
                known = it.known
            )
        }

    val spellSlotsByLevel =
        spellSlotProgression
            .groupBy { it.level }
            .mapValues { (_, rows) ->
                SpellSlotProgression(
                    slots = rows.associate {
                        it.slotLevel to it.slots
                    }
                )
            }

    val spellsKnownByLevel =
        spellsKnownProgression.associate {
            it.level to it.known
        }

    return Spellcasting(
        spellcastingAbility = AbilityScores.valueOf(spellcastingAbility),
        cantripProgression = cantripsByLevel,
        spellSlotProgression = spellSlotsByLevel,
        spellsKnown = spellsKnownByLevel
    )
}

fun SpellEntity.toDomain(): Spell =
    Spell(
        name = name,
        level = level,
        school = SpellSchool.valueOf(school),
        castingTime = castingTime,
        range = range,
        components = SpellComponents(
            verbal = verbal,
            somatic = somatic,
            material = material,
        ),
        duration = duration,
        concentration = concentration,
        ritual = ritual,
        description = description,
    )