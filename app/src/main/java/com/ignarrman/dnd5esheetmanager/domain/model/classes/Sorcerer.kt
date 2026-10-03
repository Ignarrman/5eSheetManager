package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Sorcerer(
    override val name: String = "Sorcerer",
    override val hitDice: Int = 6,
    override val features: Map<Int, List<Feature>>,
    val cantripProgression: Map<Int, CantripProgression>,
    val spellSlotProgression: Map<Int, SpellSlotProgression>,
    val spellsKnown: Map<Int, Int>,
    val sorceryPoints: Map<Int, SorceryPointProgression>
) : PlayerClass(name, hitDice, features)

data class SorceryPointProgression(
    val points: Int
)
