package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature



data class Paladin(
    override val name: String = "Paladin",
    override val hitDice: Int = 10,
    override val features: Map<Int, Feature>,
    val layOnHands: Map<Int, LayOnHandsProgression>
) : PlayerClass(name, hitDice, features)

data class LayOnHandsProgression(
    val pool: Int
)
