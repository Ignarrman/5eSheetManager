package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Bard(
    override val name: String = "Bard",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val bardicInspiration: Map<Int, BardicInspirationProgression>
) : PlayerClass(name, hitDice, features)

data class BardicInspirationProgression(
    val die: Int
)
