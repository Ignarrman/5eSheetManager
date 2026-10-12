package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellComponents
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSchool

object FakeSpells {

    val fireBolt = Spell(
        id = 1L,
        name = "Fire Bolt",
        level = 0,
        school = SpellSchool.EVOCATION,
        castingTime = "1 action",
        range = "120 feet",
        components = SpellComponents(
            verbal = false,
            somatic = true,
            material = null
        ),
        duration = "Instantaneous",
        description = "Hurl a mote of fire at a creature or object within range.",
        ritual = false,
        concentration = false,
        source = "Player's Handbook"
    )

    val mageArmor = Spell(
        id = 2L,
        name = "Mage Armor",
        level = 1,
        school = SpellSchool.ABJURATION,
        castingTime = "1 action",
        range = "Touch",
        components = SpellComponents(
            verbal = true,
            somatic = true,
            material = "A piece of cured leather"
        ),
        duration = "8 hours",
        description = "Protect a willing creature with magical force, improving its base AC.",
        ritual = false,
        concentration = false,
        source = "Player's Handbook"
    )

    val magicMissile = Spell(
        id = 3L,
        name = "Magic Missile",
        level = 1,
        school = SpellSchool.EVOCATION,
        castingTime = "1 action",
        range = "120 feet",
        components = SpellComponents(
            verbal = true,
            somatic = true,
            material = null
        ),
        duration = "Instantaneous",
        description = "Create darts of magical force that strike targets automatically.",
        ritual = false,
        concentration = false,
        source = "Player's Handbook"
    )

    val healingWord = Spell(
        id = 4L,
        name = "Healing Word",
        level = 1,
        school = SpellSchool.EVOCATION,
        castingTime = "1 bonus action",
        range = "60 feet",
        components = SpellComponents(
            verbal = true,
            somatic = false,
            material = null
        ),
        duration = "Instantaneous",
        description = "A creature you can see regains hit points when it hears your healing words.",
        ritual = false,
        concentration = false,
        source = "Player's Handbook"
    )

    val invisibility = Spell(
        id = 5L,
        name = "Invisibility",
        level = 2,
        school = SpellSchool.ILLUSION,
        castingTime = "1 action",
        range = "Touch",
        components = SpellComponents(
            verbal = true,
            somatic = true,
            material = "An eyelash encased in gum arabic"
        ),
        duration = "Up to 1 hour",
        description = "A creature you touch becomes invisible until the spell ends or its conditions are broken.",
        ritual = false,
        concentration = true,
        source = "Player's Handbook"
    )

    val all = listOf(
        fireBolt,
        mageArmor,
        magicMissile,
        healingWord,
        invisibility
    )
}