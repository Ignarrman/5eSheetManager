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
        )
    )
}