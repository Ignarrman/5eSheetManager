package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Rogue(
    override val name: String = "Rogue",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val sneakAttack: Map<Int, SneakAttackProgression>
) : PlayerClass(name, hitDice, features)

data class SneakAttackProgression(
    val dice: Int
)
