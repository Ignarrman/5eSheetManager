package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

open class PlayerClass(
    open val name: String,
    open val hitDice: Int,
    open val features: Map<Int, List<Feature>>,
    open val fightingStyles: List<FightingStyle> = emptyList(),
    open val eldritchInvocations: List<EldritchInvocation> =emptyList(),
    open val spellcasting: Spellcasting = Spellcasting.NonCaster
)

data class FightingStyle(
    val name: String,
    val description: String
)