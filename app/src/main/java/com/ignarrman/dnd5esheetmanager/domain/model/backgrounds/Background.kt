package com.ignarrman.dnd5esheetmanager.domain.model.backgrounds

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class Background(
    val id: Long? = null,
    val name: String,
    val skillProficiencies: List<String>,
    val languages: String?,
    val equipment: String?,
    val feature: Feature
)