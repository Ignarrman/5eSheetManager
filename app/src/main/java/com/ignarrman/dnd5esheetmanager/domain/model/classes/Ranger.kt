package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class Ranger(
    override val name: String = "Ranger",
    override val hitDice: Int = 10,
    override val features: Map<Int, List<Feature>>,
) : PlayerClass(name, hitDice, features)
