package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Artificer(
    override val name: String = "Artificer",
    override val hitDice: Int = 8,
    override val spellcasting: Spellcasting,
    override val features: Map<Int, List<Feature>>,
    val infusions: List<Infusion>,
    val infusionsProgression: Map<Int, InfusionProgression>
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class InfusionProgression(
    val known: Int,
    val active: Int
)

data class Infusion(
    val name: String,
    val description: String
)