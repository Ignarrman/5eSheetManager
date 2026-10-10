package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

open class PlayerClass(
    open val id: Long? = null,
    open val name: String,
    open val hitDice: Int,
    open val featureIds: Map<Int, List<Long>>,
    open val fightingStyleIds: List<Long> = emptyList(),
    open val spellcasting: Spellcasting = Spellcasting.NonCaster
)

data class FightingStyle(
    val id: Long? = null,
    val name: String,
    val description: String
)