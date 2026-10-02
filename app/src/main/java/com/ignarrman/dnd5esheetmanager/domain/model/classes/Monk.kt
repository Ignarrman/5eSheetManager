package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class FocusProgression(
    val points: Int
)

data class Monk(
    override val name: String = "Monk",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val focus: Map<Int, FocusProgression> = focusProgression
) : PlayerClass(name, hitDice, features)

private val focusProgression = mapOf(
    2 to FocusProgression(2),
    3 to FocusProgression(3),
    4 to FocusProgression(4),
    5 to FocusProgression(5),
    6 to FocusProgression(6),
    7 to FocusProgression(7),
    8 to FocusProgression(8),
    9 to FocusProgression(9),
    10 to FocusProgression(10),
    11 to FocusProgression(11),
    12 to FocusProgression(12),
    13 to FocusProgression(13),
    14 to FocusProgression(14),
    15 to FocusProgression(15),
    16 to FocusProgression(16),
    17 to FocusProgression(17),
    18 to FocusProgression(18),
    19 to FocusProgression(19),
    20 to FocusProgression(20)
)
