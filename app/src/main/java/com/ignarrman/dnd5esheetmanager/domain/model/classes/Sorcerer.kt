package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class SorceryPointProgression(
    val points: Int
)

data class Sorcerer(
    override val name: String = "Sorcerer",
    override val hitDice: Int = 6,
    override val features: List<Feature> = emptyList(),
    val sorceryPoints: Map<Int, SorceryPointProgression> = sorceryPointProgression
) : PlayerClass(name, hitDice, features)

private val sorceryPointProgression = (2..20).associateWith {
    SorceryPointProgression(it)
}
