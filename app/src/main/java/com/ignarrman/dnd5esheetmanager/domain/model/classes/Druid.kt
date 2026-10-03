package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Druid(
    override val name: String = "Druid",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    val wildShape: Map<Int, WildShapeProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class WildShapeProgression(
    val maxCr: String,
    val uses: Int
)
