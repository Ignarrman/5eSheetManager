package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.DamageType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.MasteryType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.RangeType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.WeaponProperty

object FakeWeapons {

    val longsword = Weapon(
        id = 1L,
        name = "Longsword",
        description = "A versatile martial weapon with a straight, double-edged blade.",
        price = 15,
        quantity = 1,
        damage = "1d8+1d4",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.MARTIAL,
        damageType = DamageType.SLASHING,
        normalRange = null,
        longRange = null,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.VERSATILE
        )
    )

    val dagger = Weapon(
        id = 2L,
        name = "Dagger",
        description = "A small blade suitable for close combat or throwing.",
        price = 2,
        quantity = 2,
        damage = "1d4",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.PIERCING,
        normalRange = 20,
        longRange = 60,
        proficient = true,
        attackBonus = 6,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.FINESSE,
            WeaponProperty.LIGHT,
            WeaponProperty.THROWN
        )
    )

    val shortbow = Weapon(
        id = 3L,
        name = "Shortbow",
        description = "A lightweight bow designed for quick ranged attacks.",
        price = 25,
        quantity = 1,
        damage = "1d6",
        rangeType = RangeType.RANGED,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.PIERCING,
        normalRange = 80,
        longRange = 320,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.AMMUNITION,
            WeaponProperty.TWO_HANDED
        )
    )

    val greatsword = Weapon(
        id = 4L,
        name = "Greatsword",
        description = "A massive two-handed sword that deals devastating damage.",
        price = 50,
        quantity = 1,
        damage = "2d6",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.MARTIAL,
        damageType = DamageType.SLASHING,
        normalRange = null,
        longRange = null,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.HEAVY,
            WeaponProperty.TWO_HANDED
        )
    )

    val handaxe = Weapon(
        id = 5L,
        name = "Handaxe",
        description = "A compact axe that can be wielded in melee or thrown.",
        price = 5,
        quantity = 1,
        damage = "1d6",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.SLASHING,
        normalRange = 20,
        longRange = 60,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.LIGHT,
            WeaponProperty.THROWN
        )
    )

    val heavyCrossbow = Weapon(
        id = 6L,
        name = "Heavy Crossbow",
        description = "A powerful ranged weapon that requires two hands to operate.",
        price = 50,
        quantity = 1,
        damage = "1d10",
        rangeType = RangeType.RANGED,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.PIERCING,
        normalRange = 100,
        longRange = 400,
        proficient = false,
        attackBonus = 0,
        damageBonus = 0,
        properties = listOf(
            WeaponProperty.AMMUNITION,
            WeaponProperty.HEAVY,
            WeaponProperty.LOADING,
            WeaponProperty.TWO_HANDED
        )
    )

    val all = listOf(
        longsword,
        dagger,
        shortbow,
        greatsword,
        handaxe,
        heavyCrossbow
    )
}