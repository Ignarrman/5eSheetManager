package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Bard(
    override val name: String = "Bard",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    val bardicInspiration: Map<Int, BardicInspirationProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class BardicInspirationProgression(
    val die: Int
)
