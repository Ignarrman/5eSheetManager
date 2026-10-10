package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Barbarian(
    override val id: Long?,
    override val name: String = "Barbarian",
    override val hitDice: Int = 12,
    override val features: Map<Int, List<Feature>>,
    val rage: Map<Int, RageProgression>
) : PlayerClass(id, name, hitDice, features)

data class RageProgression(
    val charges: Int,
    val damageBonus: Int
)