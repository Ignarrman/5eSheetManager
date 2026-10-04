package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Sorcerer(
    override val name: String = "Sorcerer",
    override val hitDice: Int = 6,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    val sorceryPoints: Map<Int, SorceryPointProgression>,
    val metamagics: List<Metamagic>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class SorceryPointProgression(
    val points: Int
)

data class Metamagic(
    val name: String,
    val description: String
)
