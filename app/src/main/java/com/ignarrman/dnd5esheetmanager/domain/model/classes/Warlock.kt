package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Warlock(
    override val name: String = "Warlock",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val pactMagic: Map<Int, PactMagicProgression>
) : PlayerClass(name, hitDice, features)

data class PactMagicProgression(
    val slots: Int,
    val slotLevel: Int
)
