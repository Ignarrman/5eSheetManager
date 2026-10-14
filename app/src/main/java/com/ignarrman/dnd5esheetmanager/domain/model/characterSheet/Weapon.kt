package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

import com.ignarrman.dnd5esheetmanager.domain.model.DamageType

data class Weapon(
    val id: Long? = null,
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

enum class MasteryType(val displayName: String) {
    SIMPLE("Simple"),
    MARTIAL("Martial")
}

enum class RangeType(val displayName: String) {
    MELEE("Melee"),
    RANGED("Ranged")
}

enum class WeaponProperty(val displayName: String) {
    AMMUNITION("Ammunition"),
    FINESSE("Finesse"),
    HEAVY("Heavy"),
    LIGHT("Light"),
    LOADING("Loading"),
    REACH("Reach"),
    THROWN("Thrown"),
    TWO_HANDED("Two-Handed"),
    VERSATILE("Versatile")
}

fun Weapon.getAttributes(): String = buildList {
    add(masteryType.displayName)
    add(rangeType.displayName)
    addAll(properties.map { it.displayName })
}.joinToString(", ")