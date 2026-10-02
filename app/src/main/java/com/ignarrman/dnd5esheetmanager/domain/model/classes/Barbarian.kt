package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class RageProgression(
    val charges: Int,
    val damageBonus: Int
)

data class Barbarian(
    override val name: String = "Barbarian",
    override val hitDice: Int = 12,
    override val features: List<Feature> = emptyList(),
    val rage: Map<Int, RageProgression> = barbarianRage
) : PlayerClass(name, hitDice, features)

private val barbarianRage = mapOf(
    1 to RageProgression(2, 2),
    2 to RageProgression(2, 2),
    3 to RageProgression(3, 2),
    4 to RageProgression(3, 2),
    5 to RageProgression(3, 2),
    6 to RageProgression(4, 2),
    7 to RageProgression(4, 2),
    8 to RageProgression(4, 2),
    9 to RageProgression(4, 3),
    10 to RageProgression(4, 3),
    11 to RageProgression(5, 3),
    12 to RageProgression(5, 3),
    13 to RageProgression(5, 3),
    14 to RageProgression(5, 3),
    15 to RageProgression(5, 3),
    16 to RageProgression(5, 4),
    17 to RageProgression(6, 4),
    18 to RageProgression(6, 4),
    19 to RageProgression(6, 4),
    20 to RageProgression(6, 4)
)
