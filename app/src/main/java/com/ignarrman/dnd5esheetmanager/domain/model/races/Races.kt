package com.ignarrman.dnd5esheetmanager.domain.model.races

data class Race(
    val id: Long? = null,
    val name: String,
    val size: Size,
    val speed: Speed,
    val featuresIds: List<Long> = emptyList(),
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