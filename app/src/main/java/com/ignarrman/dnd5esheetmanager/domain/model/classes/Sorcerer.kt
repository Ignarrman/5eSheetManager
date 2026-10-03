package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Sorcerer(
    override val name: String = "Sorcerer",
    override val hitDice: Int = 6,
    override val features: Map<Int, List<Feature>>,
    val sorceryPoints: Map<Int, SorceryPointProgression>
) : PlayerClass(name, hitDice, features)

data class SorceryPointProgression(
    val points: Int
)
