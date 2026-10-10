package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Barbarian(
    override val id: Long?,
    override val name: String = "Barbarian",
    override val hitDice: Int = 12,
    override val featureIds: Map<Int, List<Long>>,
    val rage: Map<Int, RageProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    featureIds = featureIds
)

data class RageProgression(
    val charges: Int,
    val damageBonus: Int
)