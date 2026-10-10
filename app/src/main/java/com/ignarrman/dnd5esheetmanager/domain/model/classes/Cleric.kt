package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Cleric(
    override val id: Long?,
    override val name: String = "Cleric",
    override val hitDice: Int = 8,
    override val featureIds: Map<Int, List<Long>>,
    override val spellcasting: Spellcasting,
    val channelDivinity: Map<Int, ChannelDivinityProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)

data class ChannelDivinityProgression(
    val uses: Int
)
