package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity

object ClassReferenceData {

    val classes = listOf(
        ClassEntity(
            id = 1L,
            name = "Barbarian",
            hitDice = 12
        ),
        ClassEntity(
            id = 2L,
            name = "Bard",
            hitDice = 8
        ),
        ClassEntity(
            id = 3L,
            name = "Artificer",
            hitDice = 8
        ),
        ClassEntity(
            id = 4L,
            name = "Cleric",
            hitDice = 8
        ),
        ClassEntity(
            id = 5L,
            name = "Druid",
            hitDice = 8
        ),
        ClassEntity(
            id = 6L,
            name = "Fighter",
            hitDice = 10
        ),
        ClassEntity(
            id = 7L,
            name = "Monk",
            hitDice = 8
        ),
        ClassEntity(
            id = 8L,
            name = "Paladin",
            hitDice = 10
        ),
        ClassEntity(
            id = 9L,
            name = "Ranger",
            hitDice = 10
        ),
        ClassEntity(
            id = 10L,
            name = "Rogue",
            hitDice = 8
        ),
        ClassEntity(
            id = 11L,
            name = "Sorcerer",
            hitDice = 6
        ),
        ClassEntity(
            id = 12L,
            name = "Warlock",
            hitDice = 8
        ),
        ClassEntity(
            id = 13L,
            name = "Wizard",
            hitDice = 6
        )
    )
}