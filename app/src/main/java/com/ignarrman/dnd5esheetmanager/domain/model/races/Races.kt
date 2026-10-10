package com.ignarrman.dnd5esheetmanager.domain.model.races

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

data class Race(
    val name: String,
    val size: Size,
    val speed: Speed,
    val features: List<Feature>,
    val source: String
)

enum class Size {
    SMALL,
    MEDIUM,
    LARGE
}

data class Speed(
    val land: Int,
    val swim: Int?,
    val climb: Int?,
    val fly: Int?
)