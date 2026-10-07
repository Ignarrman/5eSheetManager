package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

import com.ignarrman.dnd5esheetmanager.domain.model.DamageType

data class Weapon(
    val name: String,
    val description: String,
    val price: Int,
    val quantity: Int,
    val damage: String, // May contain multiple dice or damage components, for example: "1d10 + 1d4"
    val rangeType: RangeType,
    val masteryType: MasteryType,
    val damageType: DamageType,
    val normalRange: Int?,
    val longRange: Int?,
    val proficient: Boolean,
    val attackBonus: Int = 0,
    val damageBonus: Int = 0,
    val properties: List<WeaponProperty>
)

enum class MasteryType {
    SIMPLE,
    MARTIAL
}

enum class RangeType {
    MELEE,
    RANGED
}

enum class WeaponProperty {
    AMMUNITION,
    FINESSE,
    HEAVY,
    LIGHT,
    LOADING,
    REACH,
    THROWN,
    TWO_HANDED,
    VERSATILE
}