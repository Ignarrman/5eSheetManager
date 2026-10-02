package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class SneakAttackProgression(
    val dice: Int
)

data class Rogue(
    override val name: String = "Rogue",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val sneakAttack: Map<Int, SneakAttackProgression> = sneakAttackProgression
) : PlayerClass(name, hitDice, features)

private val sneakAttackProgression = mapOf(
    1 to SneakAttackProgression(1),
    2 to SneakAttackProgression(1),
    3 to SneakAttackProgression(2),
    4 to SneakAttackProgression(2),
    5 to SneakAttackProgression(3),
    6 to SneakAttackProgression(3),
    7 to SneakAttackProgression(4),
    8 to SneakAttackProgression(4),
    9 to SneakAttackProgression(5),
    10 to SneakAttackProgression(5),
    11 to SneakAttackProgression(6),
    12 to SneakAttackProgression(6),
    13 to SneakAttackProgression(7),
    14 to SneakAttackProgression(7),
    15 to SneakAttackProgression(8),
    16 to SneakAttackProgression(8),
    17 to SneakAttackProgression(9),
    18 to SneakAttackProgression(9),
    19 to SneakAttackProgression(10),
    20 to SneakAttackProgression(10)
)
