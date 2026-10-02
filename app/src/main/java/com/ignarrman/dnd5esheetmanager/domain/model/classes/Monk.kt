package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature



data class Monk(
    override val name: String = "Monk",
    override val hitDice: Int = 8,
    override val features: Map<Int, Feature>,
    val focus: Map<Int, FocusProgression>
) : PlayerClass(name, hitDice, features)

data class FocusProgression(
    val points: Int
)
