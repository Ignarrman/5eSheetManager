package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

data class Ranger(
    override val id: Long?,
    override val name: String = "Ranger",
    override val hitDice: Int = 10,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting,
    override val fightingStyleIds: List<Long>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)
