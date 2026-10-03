package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

data class Ranger(
    override val name: String = "Ranger",
    override val hitDice: Int = 10,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    override val fightingStyles: List<FightingStyle>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)
