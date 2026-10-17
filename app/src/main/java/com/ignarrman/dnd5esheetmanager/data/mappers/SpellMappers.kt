package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellComponents
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSchool
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

fun SpellcastingEntity.toDomain(
    spellSlotProgression: List<SpellSlotProgressionEntity>,
): Spellcasting {


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

    return Spellcasting(
        spellcastingAbility = AbilityScores.valueOf(spellcastingAbility),
        spellSlotProgression = spellSlotsByLevel,
    )
}

fun SpellEntity.toDomain(): Spell =
    Spell(
        id = id,
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
        source = source
    )