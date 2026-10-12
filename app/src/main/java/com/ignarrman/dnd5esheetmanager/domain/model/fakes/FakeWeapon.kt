package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.DamageType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.MasteryType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.RangeType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.WeaponProperty

object FakeWeapon {

    val longsword = Weapon(
        id = 1L,
        name = "Longsword",
        description = "A versatile martial melee weapon with a straight blade.",
        price = 15,
        quantity = 1,
        damage = "1d8",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.MARTIAL,
        damageType = DamageType.SLASHING,
        normalRange = null,
        longRange = null,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(WeaponProperty.VERSATILE)
    )

    val dagger = Weapon(
        id = 2L,
        name = "Dagger",
        description = "A small blade suitable for melee combat or throwing.",
        price = 2,
        quantity = 2,
        damage = "1d4",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.PIERCING,
        normalRange = 20,
        longRange = 60,
        proficient = true,
        attackBonus = 5,
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
        description = "A compact bow used to attack enemies from a distance.",
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

    val greataxe = Weapon(
        id = 4L,
        name = "Greataxe",
        description = "A heavy two-handed martial weapon that deals slashing damage.",
        price = 30,
        quantity = 1,
        damage = "1d12",
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

    val spear = Weapon(
        id = 5L,
        name = "Spear",
        description = "A simple weapon that can be wielded in melee or thrown.",
        price = 1,
        quantity = 1,
        damage = "1d6",
        rangeType = RangeType.MELEE,
        masteryType = MasteryType.SIMPLE,
        damageType = DamageType.PIERCING,
        normalRange = 20,
        longRange = 60,
        proficient = true,
        attackBonus = 5,
        damageBonus = 3,
        properties = listOf(
            WeaponProperty.THROWN,
            WeaponProperty.VERSATILE
        )
    )

    val all = listOf(
        longsword,
        dagger,
        shortbow,
        greataxe,
        spear
    )
}