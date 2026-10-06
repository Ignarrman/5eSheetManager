package com.ignarrman.dnd5esheetmanager.domain.model.feat

data class Feat(
    val name: String,
    val description: String,
    val prerequisite: String,
    val abilityBonus: String
)
