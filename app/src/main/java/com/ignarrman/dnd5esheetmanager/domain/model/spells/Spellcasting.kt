package com.ignarrman.dnd5esheetmanager.domain.model.spells

import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores

open class Spellcasting(
    val spellcastingAbility: AbilityScores,
    val spellSlotProgression: Map<Int, SpellSlotProgression>,
) {
    companion object NonCaster: Spellcasting(
        spellcastingAbility = AbilityScores.INT,
        spellSlotProgression = emptyMap(),
    )
}

data class SpellSlotProgression(
    val slots: Map<Int, Int>
)

data class SpentSpellSlots(
    val slots: Map<Int, Int> = emptyMap()
)

fun getDifficultyClass(proficiencyBonus: Int, scoreBonus: Int) =
    8+proficiencyBonus+scoreBonus
