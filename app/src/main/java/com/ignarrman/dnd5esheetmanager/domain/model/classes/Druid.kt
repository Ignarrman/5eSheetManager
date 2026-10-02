package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class WildShapeProgression(
    val maxCr: String,
    val uses: Int
)

data class Druid(
    override val name: String = "Druid",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val wildShape: Map<Int, WildShapeProgression> = wildShapeProgression
) : PlayerClass(name, hitDice, features)

private val wildShapeProgression = mapOf(
    2 to WildShapeProgression("1/4", 2),
    4 to WildShapeProgression("1/2", 2),
    8 to WildShapeProgression("1", 2)
)
