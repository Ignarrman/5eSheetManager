package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Fighter(
    override val name: String = "Fighter",
    override val hitDice: Int = 10,
    override val features: Map<Int, List<Feature>>,
    override val fightingStyles: List<FightingStyle>,
    val progression: Map<Int, FighterProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    fightingStyles = fightingStyles,
    features = features
)

data class FighterProgression(
    val actionSurgeUses: Int,
    val indomitableUses: Int
)
