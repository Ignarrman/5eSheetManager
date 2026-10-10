package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Sorcerer(
    override val id: Long?,
    override val name: String = "Sorcerer",
    override val hitDice: Int = 6,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting,
    val sorceryPoints: Map<Int, SorceryPointProgression>,
    val metamagics: List<Metamagic>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)

data class SorceryPointProgression(
    val points: Int
)

data class Metamagic(
    val name: String,
    val description: String
)
