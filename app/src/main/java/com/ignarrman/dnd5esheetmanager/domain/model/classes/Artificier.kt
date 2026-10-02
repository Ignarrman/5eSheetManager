package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class InfusionProgression(
    val known: Int,
    val active: Int
)

data class Artificer(
    override val name: String = "Artificer",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val infusions: Map<Int, InfusionProgression> = infusionProgression
) : PlayerClass(name, hitDice, features)

private val infusionProgression = mapOf(
    2 to InfusionProgression(4, 2),
    3 to InfusionProgression(4, 2),
    4 to InfusionProgression(4, 2),
    5 to InfusionProgression(4, 2),
    6 to InfusionProgression(6, 3),
    7 to InfusionProgression(6, 3),
    8 to InfusionProgression(6, 3),
    9 to InfusionProgression(6, 3),
    10 to InfusionProgression(8, 4),
    11 to InfusionProgression(8, 4),
    12 to InfusionProgression(8, 4),
    13 to InfusionProgression(8, 4),
    14 to InfusionProgression(10, 5),
    15 to InfusionProgression(10, 5),
    16 to InfusionProgression(10, 5),
    17 to InfusionProgression(10, 5),
    18 to InfusionProgression(12, 6),
    19 to InfusionProgression(12, 6),
    20 to InfusionProgression(12, 6)
)
