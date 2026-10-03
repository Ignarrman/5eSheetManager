package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

open class PlayerClass(
    open val name: String,
    open val hitDice: Int,
    open val features: Map<Int, List<Feature>>
)

data class CantripProgression(
    val known: Int
)

data class SpellSlotProgression(
    val slots: Map<Int, Int>
)

enum class FightingStyle {
    ARCHERY,
    DEFENSE,
    DUELING,
    GREAT_WEAPON_FIGHTING,
    PROTECTION,
    TWO_WEAPON_FIGHTING,
    BLIND_FIGHTING,
    INTERCEPTION,
    SUPERIOR_TECHNIQUE,
    THROWN_WEAPON_FIGHTING,
    UNARMED_FIGHTING,
    DRUIDIC_WARRIOR,
    BLESSED_WARRIOR
}