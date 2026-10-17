package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpentSpellSlots

object FakeSpentSpellSlots {

    val full = SpentSpellSlots(
        slots = mapOf(
            1 to 4,
            2 to 3,
            3 to 2,
            4 to 1
        )
    )

    val partial = SpentSpellSlots(
        slots = mapOf(
            1 to 2,
            2 to 1,
            3 to 0
        )
    )

    val empty = SpentSpellSlots(
        slots = emptyMap()
    )

    val all = listOf(
        full,
        partial,
        empty
    )
}