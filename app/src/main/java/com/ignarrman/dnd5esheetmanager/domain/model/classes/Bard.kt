package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class BardicInspirationProgression(
    val die: Int
)

data class Bard(
    override val name: String = "Bard",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val bardicInspiration: Map<Int, BardicInspirationProgression> = bardicInspirationProgression
) : PlayerClass(name, hitDice, features)

private val bardicInspirationProgression = mapOf(
    1 to BardicInspirationProgression(6),
    2 to BardicInspirationProgression(6),
    3 to BardicInspirationProgression(8),
    4 to BardicInspirationProgression(8),
    5 to BardicInspirationProgression(8),
    6 to BardicInspirationProgression(8),
    7 to BardicInspirationProgression(10),
    8 to BardicInspirationProgression(10),
    9 to BardicInspirationProgression(10),
    10 to BardicInspirationProgression(10),
    11 to BardicInspirationProgression(12),
    12 to BardicInspirationProgression(12),
    13 to BardicInspirationProgression(12),
    14 to BardicInspirationProgression(12),
    15 to BardicInspirationProgression(12),
    16 to BardicInspirationProgression(12),
    17 to BardicInspirationProgression(12),
    18 to BardicInspirationProgression(12),
    19 to BardicInspirationProgression(12),
    20 to BardicInspirationProgression(12)
)
