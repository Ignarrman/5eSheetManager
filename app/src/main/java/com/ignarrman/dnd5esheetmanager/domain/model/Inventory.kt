package com.ignarrman.dnd5esheetmanager.domain.model

data class Inventory(
    val items: Item
)

open class Item(
    open val name: String,
    open val description: String,
    open val price: Int
)

data class Weapon(
    override val name: String,
    override val description: String,
    override val price: Int,
    val damageDie: Int,
    val rangeType: RangeType,
    val masteryType: MasteryType,
    val damageType: DamageType,
    val rangeDistanceMin: Int,
    val rangeDistanceMax: Int,
    val proficient: Boolean,
    val features: List<WeaponProperty>
): Item(name,description,price)

enum class MasteryType {
    SIMPLE,
    MARTIAL
}

enum class RangeType {
    MELEE,
    RANGE
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
