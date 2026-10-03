package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature



data class Monk(
    override val name: String = "Monk",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val martialArtsProgression: Map<Int, MonkProgression>
) : PlayerClass(name, hitDice, features)

data class MonkProgression(
    val martialArtsDie: Int,
    val kiPoints: Int
)
