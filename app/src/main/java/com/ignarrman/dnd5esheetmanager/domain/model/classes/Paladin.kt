package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Paladin(
    override val name: String = "Paladin",
    override val hitDice: Int = 10,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    override val fightingStyles: List<FightingStyle>,
    val layOnHands: Map<Int, LayOnHandsProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    fightingStyles = fightingStyles,
    features = features
)

data class LayOnHandsProgression(
    val pool: Int
)
