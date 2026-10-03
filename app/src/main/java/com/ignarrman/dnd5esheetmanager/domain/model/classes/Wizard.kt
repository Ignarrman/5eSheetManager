package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

data class Wizard(
    override val name: String = "Wizard",
    override val hitDice: Int = 6,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)
