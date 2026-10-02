package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class Wizard(
    override val name: String = "Wizard",
    override val hitDice: Int = 6,
    override val features: List<Feature> = emptyList()
) : PlayerClass(name, hitDice, features)
