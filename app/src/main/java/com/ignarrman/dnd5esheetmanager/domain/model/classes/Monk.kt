package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature



data class Monk(
    override val id: Long?,
    override val name: String = "Monk",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val martialArtsProgression: Map<Int, MonkProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    features = features
)

data class MonkProgression(
    val martialArtsDie: Int,
    val kiPoints: Int
)
