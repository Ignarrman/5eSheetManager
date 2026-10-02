package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class FighterProgression(
    val actionSurgeUses: Int,
    val indomitableUses: Int
)

data class Fighter(
    override val name: String = "Fighter",
    override val hitDice: Int = 10,
    override val features: List<Feature> = emptyList(),
    val progression: Map<Int, FighterProgression> = fighterProgression
) : PlayerClass(name, hitDice, features)

private val fighterProgression = mapOf(
    1 to FighterProgression(0, 0),
    2 to FighterProgression(1, 0),
    3 to FighterProgression(1, 0),
    9 to FighterProgression(1, 1),
    13 to FighterProgression(1, 2),
    17 to FighterProgression(2, 2)
)
