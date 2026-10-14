package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.races.Size
import com.ignarrman.dnd5esheetmanager.domain.model.races.Speed

object FakeRace {

    val human = Race(
        id = 1L,
        name = "Human",
        size = Size.MEDIUM,
        speed = Speed(land = 30, swim = null, climb = null, fly = null),
        featuresIds = emptyList(),
        source = "Player's Handbook"
    )

    val elf = Race(
        id = 2L,
        name = "Sea Elf",
        size = Size.MEDIUM,
        speed = Speed(land = 30, swim = 30, climb = null, fly = null),
        featuresIds = emptyList(),
        source = "Player's Handbook"
    )

    val dwarf = Race(
        id = 3L,
        name = "Dwarf",
        size = Size.MEDIUM,
        speed = Speed(land = 25, swim = null, climb = 30, fly = null),
        featuresIds = emptyList(),
        source = "Player's Handbook"
    )

    val halfling = Race(
        id = 4L,
        name = "Halfling",
        size = Size.SMALL,
        speed = Speed(land = 25, swim = null, climb = null, fly = 30),
        featuresIds = emptyList(),
        source = "Player's Handbook"
    )

    val dragonborn = Race(
        id = 5L,
        name = "Dragonborn",
        size = Size.MEDIUM,
        speed = Speed(land = 30, swim = 30, climb = 30, fly = 30),
        featuresIds = emptyList(),
        source = "Player's Handbook"
    )

    val all = listOf(
        human,
        elf,
        dwarf,
        halfling,
        dragonborn
    )
}