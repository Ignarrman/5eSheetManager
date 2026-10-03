package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Cleric(
    override val name: String = "Cleric",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    val channelDivinity: Map<Int, ChannelDivinityProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class ChannelDivinityProgression(
    val uses: Int
)
