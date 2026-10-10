package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Artificer(
    override val id: Long?,
    override val name: String = "Artificer",
    override val hitDice: Int = 8,
    override val spellcasting: Spellcasting,
    override val featureIds: Map<Int, List<Long>>,
    val infusions: List<Infusion>,
    val infusionsProgression: Map<Int, InfusionProgression>
) : PlayerClass(
    id = id,
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    featureIds = featureIds
)

data class InfusionProgression(
    val known: Int,
    val active: Int
)

data class Infusion(
    val name: String,
    val description: String
)