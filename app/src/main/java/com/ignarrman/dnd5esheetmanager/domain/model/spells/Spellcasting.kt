package com.ignarrman.dnd5esheetmanager.domain.model.spells

import com.ignarrman.dnd5esheetmanager.domain.model.AbilityScores

open class Spellcasting(
    val spellcastingAbility: AbilityScores,
    val cantripProgression: Map<Int, CantripProgression>,
    val spellSlotProgression: Map<Int, SpellSlotProgression>,
    val spellsKnown: Map<Int, Int>,
) {
    companion object NonCaster: Spellcasting(
        spellcastingAbility = AbilityScores.INT,
        cantripProgression = emptyMap(),
        spellSlotProgression = emptyMap(),
        spellsKnown = emptyMap()
    )
}

data class CantripProgression(
    val known: Int
)

data class SpellSlotProgression(
    val slots: Map<Int, Int>
)
