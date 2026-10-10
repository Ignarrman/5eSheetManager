package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

data class Wizard(
    override val id: Long?,
    override val name: String = "Wizard",
    override val hitDice: Int = 6,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)
