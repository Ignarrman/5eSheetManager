package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


data class Warlock(
    override val name: String = "Warlock",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    override val spellcasting: Spellcasting,
    val eldritchInvocations: List<EldritchInvocation>,
    val eldritchInvocationsKnown: Map<Int, EldritchInvocationsKnownProgression>,
) : PlayerClass(
    name = name,
    hitDice = hitDice,
    spellcasting = spellcasting,
    features = features
)

data class EldritchInvocation(
    val name: String,
    val description: String
)

data class EldritchInvocationsKnownProgression(
    val known: Int
)
