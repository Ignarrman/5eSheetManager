package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Druid(
    override val name: String = "Druid",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val wildShape: Map<Int, WildShapeProgression>
) : PlayerClass(name, hitDice, features)

data class WildShapeProgression(
    val maxCr: String,
    val uses: Int
)
