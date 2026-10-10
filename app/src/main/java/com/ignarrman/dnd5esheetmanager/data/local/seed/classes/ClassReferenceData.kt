package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity

object ClassReferenceData {

    const val BARBARIAN_ID = 1L
    const val BARD_ID = 2L
    const val ARTIFICER_ID = 3L
    const val CLERIC_ID = 4L
    const val DRUID_ID = 5L
    const val FIGHTER_ID = 6L
    const val MONK_ID = 7L
    const val PALADIN_ID = 8L
    const val RANGER_ID = 9L
    const val ROGUE_ID = 10L
    const val SORCERER_ID = 11L
    const val WARLOCK_ID = 12L
    const val WIZARD_ID = 13L

    val classes = listOf(
        ClassEntity(
            id = BARBARIAN_ID,
            name = "Barbarian",
            hitDice = 12
        ),
        ClassEntity(
            id = BARD_ID,
            name = "Bard",
            hitDice = 8
        ),
        ClassEntity(
            id = ARTIFICER_ID,
            name = "Artificer",
            hitDice = 8
        ),
        ClassEntity(
            id = CLERIC_ID,
            name = "Cleric",
            hitDice = 8
        ),
        ClassEntity(
            id = DRUID_ID,
            name = "Druid",
            hitDice = 8
        ),
        ClassEntity(
            id = FIGHTER_ID,
            name = "Fighter",
            hitDice = 10
        ),
        ClassEntity(
            id = MONK_ID,
            name = "Monk",
            hitDice = 8
        ),
        ClassEntity(
            id = PALADIN_ID,
            name = "Paladin",
            hitDice = 10
        ),
        ClassEntity(
            id = RANGER_ID,
            name = "Ranger",
            hitDice = 10
        ),
        ClassEntity(
            id = ROGUE_ID,
            name = "Rogue",
            hitDice = 8
        ),
        ClassEntity(
            id = SORCERER_ID,
            name = "Sorcerer",
            hitDice = 6
        ),
        ClassEntity(
            id = WARLOCK_ID,
            name = "Warlock",
            hitDice = 8
        ),
        ClassEntity(
            id = WIZARD_ID,
            name = "Wizard",
            hitDice = 6
        )
    )
}