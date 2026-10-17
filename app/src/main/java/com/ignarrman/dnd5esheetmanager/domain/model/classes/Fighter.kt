package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Fighter(
    override val id: Long?,
    override val name: String = "Fighter",
    override val hitDice: Int = 10,
    override val features: Map<Int, List<Feature>>,
    override val fightingStyleIds: List<Long>,
    val progression: Map<Int, FighterProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    fightingStyleIds = fightingStyleIds,
    features = features
)

data class FighterProgression(
    val actionSurgeUses: Int,
    val indomitableUses: Int
)
