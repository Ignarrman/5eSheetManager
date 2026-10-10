package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Druid(
    override val id: Long?,
    override val name: String = "Druid",
    override val hitDice: Int = 8,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting,
    val wildShape: Map<Int, WildShapeProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)

data class WildShapeProgression(
    val maxCr: String,
    val uses: Int
)
