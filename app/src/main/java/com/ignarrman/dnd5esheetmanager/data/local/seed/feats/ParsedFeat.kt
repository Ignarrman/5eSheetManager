package com.ignarrman.dnd5esheetmanager.data.local.seed.feats

data class ParsedFeat(
    val id: Long,
    val name: String,
    val description: String,
    val prerequisite: String,
    val abilityBonus: String
)
