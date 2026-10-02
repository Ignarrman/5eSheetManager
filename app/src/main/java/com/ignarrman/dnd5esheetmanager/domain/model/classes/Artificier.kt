package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Artificer(
    override val name: String = "Artificer",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val infusions: Map<Int, InfusionProgression>
) : PlayerClass(name, hitDice, features)

data class InfusionProgression(
    val known: Int,
    val active: Int
)