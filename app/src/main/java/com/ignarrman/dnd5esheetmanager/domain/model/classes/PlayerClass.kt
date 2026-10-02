package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

open class PlayerClass(
    open val name: String,
    open val hitDice: Int,
    open val features: Map<Int, Feature>
)
