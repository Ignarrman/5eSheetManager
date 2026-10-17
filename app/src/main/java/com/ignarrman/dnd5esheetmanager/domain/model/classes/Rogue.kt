package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Rogue(
    override val id: Long?,
    override val name: String = "Rogue",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val sneakAttack: Map<Int, SneakAttackProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    features = features
)

data class SneakAttackProgression(
    val dice: Int
)
