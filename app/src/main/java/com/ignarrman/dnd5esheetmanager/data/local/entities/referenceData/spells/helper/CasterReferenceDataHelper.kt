package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity

fun fullCasterSpellSlots(
    classId: Long
): List<SpellSlotProgressionEntity> =
    listOf(
        1 to mapOf(1 to 2),
        2 to mapOf(1 to 3),
        3 to mapOf(1 to 4, 2 to 2),
        4 to mapOf(1 to 4, 2 to 3),
        5 to mapOf(1 to 4, 2 to 3, 3 to 2),
        6 to mapOf(1 to 4, 2 to 3, 3 to 3),
        7 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 1),
        8 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2),
        9 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 1),
        10 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2),
        11 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1),
        12 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1),
        13 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1),
        14 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1),
        15 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1),
        16 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1),
        17 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1, 9 to 1),
        18 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1, 9 to 1),
        19 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1, 9 to 1),
        20 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2, 5 to 2, 6 to 1, 7 to 1, 8 to 1, 9 to 1)
    ).flatMap { (level, slots) ->
        slots.map { (slotLevel, amount) ->
            SpellSlotProgressionEntity(
                classId = classId,
                level = level,
                slotLevel = slotLevel,
                slots = amount
            )
        }
    }


fun halfCasterSpellSlots(
    classId: Long,
    startLevel: Int = 2
): List<SpellSlotProgressionEntity> =
    listOf(
        1 to mapOf(1 to 2),
        2 to mapOf(1 to 2),
        3 to mapOf(1 to 3),
        4 to mapOf(1 to 3),
        5 to mapOf(1 to 4, 2 to 2),
        6 to mapOf(1 to 4, 2 to 2),
        7 to mapOf(1 to 4, 2 to 3),
        8 to mapOf(1 to 4, 2 to 3),
        9 to mapOf(1 to 4, 2 to 3, 3 to 2),
        10 to mapOf(1 to 4, 2 to 3, 3 to 2),
        11 to mapOf(1 to 4, 2 to 3, 3 to 3),
        12 to mapOf(1 to 4, 2 to 3, 3 to 3),
        13 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 1),
        14 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 1),
        15 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2),
        16 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 2),
        17 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 3, 5 to 1),
        18 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 3, 5 to 1),
        19 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 3, 5 to 2),
        20 to mapOf(1 to 4, 2 to 3, 3 to 3, 4 to 3, 5 to 2)
    )
        .filter { (level, _) -> level >= startLevel }
        .flatMap { (level, slots) ->
            slots.map { (slotLevel, amount) ->
                SpellSlotProgressionEntity(
                    classId = classId,
                    level = level,
                    slotLevel = slotLevel,
                    slots = amount
                )
            }
        }

fun pactMagicSpellSlots(
    classId: Long
): List<SpellSlotProgressionEntity> =
    listOf(
        1 to mapOf(1 to 1),
        2 to mapOf(1 to 2),
        3 to mapOf(2 to 2),
        4 to mapOf(2 to 2),
        5 to mapOf(3 to 2),
        6 to mapOf(3 to 2),
        7 to mapOf(4 to 2),
        8 to mapOf(4 to 2),
        9 to mapOf(5 to 2),
        10 to mapOf(5 to 2),
        11 to mapOf(5 to 3),
        12 to mapOf(5 to 3),
        13 to mapOf(5 to 3),
        14 to mapOf(5 to 3),
        15 to mapOf(5 to 3),
        16 to mapOf(5 to 3),
        17 to mapOf(5 to 4),
        18 to mapOf(5 to 4),
        19 to mapOf(5 to 4),
        20 to mapOf(5 to 4)
    ).flatMap { (level, slots) ->
        slots.map { (slotLevel, amount) ->
            SpellSlotProgressionEntity(
                classId = classId,
                level = level,
                slotLevel = slotLevel,
                slots = amount
            )
        }
    }