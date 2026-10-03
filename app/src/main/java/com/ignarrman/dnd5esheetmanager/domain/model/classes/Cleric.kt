package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature


data class Cleric(
    override val name: String = "Cleric",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val channelDivinity: Map<Int, ChannelDivinityProgression>
) : PlayerClass(name, hitDice, features)

data class ChannelDivinityProgression(
    val uses: Int
)
