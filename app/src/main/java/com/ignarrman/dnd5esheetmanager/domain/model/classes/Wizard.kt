package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class Wizard(
    override val name: String = "Wizard",
    override val hitDice: Int = 6,
    override val features: Map<Int, List<Feature>>,
    val cantripProgression: Map<Int, CantripProgression>,
    val spellSlotProgression: Map<Int, SpellSlotProgression>
    ) : PlayerClass(name, hitDice, features)
