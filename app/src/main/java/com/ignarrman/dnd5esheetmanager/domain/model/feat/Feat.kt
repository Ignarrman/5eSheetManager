package com.ignarrman.dnd5esheetmanager.domain.model.feat

data class Feat(
    val id: Long? = null,
    val name: String,
    val description: String,
    val prerequisite: String,
    val abilityBonus: String
)
