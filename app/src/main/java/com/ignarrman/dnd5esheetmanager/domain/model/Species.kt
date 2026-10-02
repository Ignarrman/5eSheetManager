package com.ignarrman.dnd5esheetmanager.domain.model

data class Species(
    val name: String,
    val size: Size,
    val speed: Speed,
    val features: List<Feature>
)

enum class Size {
    SMALL,
    MEDIUM,
    LARGE
}

data class Speed (
    val land: Int,
    val swim: Int,
    val climb: Int,
    val fly: Int
)