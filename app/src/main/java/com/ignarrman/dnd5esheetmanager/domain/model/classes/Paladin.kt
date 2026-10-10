package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Paladin(
    override val id: Long?,
    override val name: String = "Paladin",
    override val hitDice: Int = 10,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting,
    override val fightingStyleIds: List<Long>,
    val layOnHands: Map<Int, LayOnHandsProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    fightingStyleIds = fightingStyleIds,
    featureIds = featureIds
)

data class LayOnHandsProgression(
    val pool: Int
)
