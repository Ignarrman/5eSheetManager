package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class PactMagicProgression(
    val slots: Int,
    val slotLevel: Int
)

data class Warlock(
    override val name: String = "Warlock",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val pactMagic: Map<Int, PactMagicProgression> = pactMagicProgression
) : PlayerClass(name, hitDice, features)

private val pactMagicProgression = mapOf(
    1 to PactMagicProgression(1, 1),
    2 to PactMagicProgression(2, 1),
    3 to PactMagicProgression(2, 2),
    4 to PactMagicProgression(2, 2),
    5 to PactMagicProgression(2, 3),
    6 to PactMagicProgression(2, 3),
    7 to PactMagicProgression(2, 4),
    8 to PactMagicProgression(2, 4),
    9 to PactMagicProgression(2, 5),
    10 to PactMagicProgression(2, 5),
    11 to PactMagicProgression(3, 5),
    12 to PactMagicProgression(3, 5),
    13 to PactMagicProgression(3, 5),
    14 to PactMagicProgression(4, 5),
    15 to PactMagicProgression(4, 5),
    16 to PactMagicProgression(4, 5),
    17 to PactMagicProgression(4, 5),
    18 to PactMagicProgression(4, 5),
    19 to PactMagicProgression(4, 5),
    20 to PactMagicProgression(4, 5)
)
