package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Warlock(
    override val name: String = "Warlock",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val cantripProgression: Map<Int, CantripProgression>,
    val spellsKnown: Map<Int, Int>,
    val spellSlotProgression: Map<Int, SpellSlotProgression>,
    val eldritchInvocationsKnown: Map<Int, Int>
) : PlayerClass(name, hitDice, features)
