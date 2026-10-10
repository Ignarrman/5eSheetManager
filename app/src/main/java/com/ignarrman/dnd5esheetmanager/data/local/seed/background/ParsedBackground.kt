package com.ignarrman.dnd5esheetmanager.data.local.seed.background

data class ParsedBackground(
    val id: Long,
    val name: String,
    val skillProficiencies: List<String>,
    val languages: String?,
    val equipment: String?,
    val featureName: String,
    val featureDescription: String
)