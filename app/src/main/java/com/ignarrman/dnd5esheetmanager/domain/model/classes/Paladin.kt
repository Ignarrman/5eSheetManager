package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class LayOnHandsProgression(
    val pool: Int
)

data class Paladin(
    override val name: String = "Paladin",
    override val hitDice: Int = 10,
    override val features: List<Feature> = emptyList(),
    val layOnHands: Map<Int, LayOnHandsProgression> = layOnHandsProgression
) : PlayerClass(name, hitDice, features)

private val layOnHandsProgression = (1..20).associateWith {
    LayOnHandsProgression(it * 5)
}
