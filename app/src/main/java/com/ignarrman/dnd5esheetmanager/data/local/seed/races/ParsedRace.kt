package com.ignarrman.dnd5esheetmanager.data.local.seed.races


data class ParsedRace(
    val id: Long,
    val name: String,
    val source: String,
    val size: String,
    val landSpeed: Int,
    val swimSpeed: Int?,
    val climbSpeed: Int?,
    val flySpeed: Int?,
    val features: List<ParsedRaceFeature>,
)

data class ParsedRaceFeature(
    val name: String,
    val description: String
)
