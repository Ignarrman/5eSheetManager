package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class ChannelDivinityProgression(
    val uses: Int
)

data class Cleric(
    override val name: String = "Cleric",
    override val hitDice: Int = 8,
    override val features: List<Feature> = emptyList(),
    val channelDivinity: Map<Int, ChannelDivinityProgression> = channelDivinityProgression
) : PlayerClass(name, hitDice, features)

private val channelDivinityProgression = mapOf(
    2 to ChannelDivinityProgression(1),
    3 to ChannelDivinityProgression(1),
    4 to ChannelDivinityProgression(1),
    5 to ChannelDivinityProgression(2),
    6 to ChannelDivinityProgression(2),
    7 to ChannelDivinityProgression(2),
    8 to ChannelDivinityProgression(2),
    9 to ChannelDivinityProgression(2),
    10 to ChannelDivinityProgression(2),
    11 to ChannelDivinityProgression(2),
    12 to ChannelDivinityProgression(2),
    13 to ChannelDivinityProgression(2),
    14 to ChannelDivinityProgression(2),
    15 to ChannelDivinityProgression(2),
    16 to ChannelDivinityProgression(2),
    17 to ChannelDivinityProgression(3),
    18 to ChannelDivinityProgression(3),
    19 to ChannelDivinityProgression(3),
    20 to ChannelDivinityProgression(3)
)
