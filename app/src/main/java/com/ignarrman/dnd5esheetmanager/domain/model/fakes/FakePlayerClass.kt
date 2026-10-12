package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Artificer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Bard
import com.ignarrman.dnd5esheetmanager.domain.model.classes.BardicInspirationProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.ChannelDivinityProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Cleric
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Druid
import com.ignarrman.dnd5esheetmanager.domain.model.classes.EldritchInvocation
import com.ignarrman.dnd5esheetmanager.domain.model.classes.EldritchInvocationsKnownProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Fighter
import com.ignarrman.dnd5esheetmanager.domain.model.classes.FighterProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Infusion
import com.ignarrman.dnd5esheetmanager.domain.model.classes.InfusionProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.LayOnHandsProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Metamagic
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Monk
import com.ignarrman.dnd5esheetmanager.domain.model.classes.MonkProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Paladin
import com.ignarrman.dnd5esheetmanager.domain.model.classes.RageProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Ranger
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Rogue
import com.ignarrman.dnd5esheetmanager.domain.model.classes.SneakAttackProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Sorcerer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.SorceryPointProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Warlock
import com.ignarrman.dnd5esheetmanager.domain.model.classes.WildShapeProgression
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Wizard
import com.ignarrman.dnd5esheetmanager.domain.model.spells.CantripProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting


object FakePlayerClass {

    val artificer = Artificer(
        id = 1L,
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.INT,
            cantripProgression = mapOf(
                1 to CantripProgression(2),
                10 to CantripProgression(4)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 2)),
                3 to SpellSlotProgression(mapOf(1 to 3, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 2))
            ),
            spellsKnown = mapOf(
                1 to 2,
                2 to 3,
                3 to 3,
                5 to 4
            )
        ),
        featureIds = emptyMap(),
        infusions = listOf(
            Infusion(
                name = "Enhanced Defense",
                description = "A magical infusion that improves a suit of armor or a shield."
            ),
            Infusion(
                name = "Enhanced Weapon",
                description = "A magical infusion that improves a weapon."
            )
        ),
        infusionsProgression = mapOf(
            2 to InfusionProgression(known = 4, active = 2),
            6 to InfusionProgression(known = 6, active = 3),
            10 to InfusionProgression(known = 8, active = 4),
            20 to InfusionProgression(known = 12, active = 6)
        )
    )

    val barbarian = Barbarian(
        id = 2L,
        featureIds = emptyMap(),
        rage = mapOf(
            1 to RageProgression(charges = 2, damageBonus = 2),
            2 to RageProgression(charges = 2, damageBonus = 2),
            3 to RageProgression(charges = 3, damageBonus = 2),
            5 to RageProgression(charges = 3, damageBonus = 2),
            9 to RageProgression(charges = 4, damageBonus = 3),
            16 to RageProgression(charges = 5, damageBonus = 4),
            20 to RageProgression(charges = 999, damageBonus = 4)
        )
    )

    val bard = Bard(
        id = 3L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.CHA,
            cantripProgression = mapOf(
                1 to CantripProgression(2),
                4 to CantripProgression(3),
                10 to CantripProgression(4)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 3)),
                3 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = mapOf(
                1 to 4,
                2 to 5,
                3 to 6,
                5 to 8
            )
        ),
        bardicInspiration = mapOf(
            1 to BardicInspirationProgression(die = 6),
            5 to BardicInspirationProgression(die = 8),
            10 to BardicInspirationProgression(die = 10),
            15 to BardicInspirationProgression(die = 12)
        )
    )

    val cleric = Cleric(
        id = 4L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.WIS,
            cantripProgression = mapOf(
                1 to CantripProgression(3),
                4 to CantripProgression(4),
                10 to CantripProgression(5)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 3)),
                3 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = emptyMap()
        ),
        channelDivinity = mapOf(
            2 to ChannelDivinityProgression(uses = 1),
            6 to ChannelDivinityProgression(uses = 2),
            18 to ChannelDivinityProgression(uses = 3)
        )
    )

    val druid = Druid(
        id = 5L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.WIS,
            cantripProgression = mapOf(
                1 to CantripProgression(2),
                4 to CantripProgression(3),
                10 to CantripProgression(4)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 3)),
                3 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = emptyMap()
        ),
        wildShape = mapOf(
            2 to WildShapeProgression(maxCr = "1/4", uses = 2),
            4 to WildShapeProgression(maxCr = "1/2", uses = 2),
            8 to WildShapeProgression(maxCr = "1", uses = 2)
        )
    )

    val fighter = Fighter(
        id = 6L,
        featureIds = emptyMap(),
        fightingStyleIds = emptyList(),
        progression = mapOf(
            2 to FighterProgression(
                actionSurgeUses = 1,
                indomitableUses = 0
            ),
            5 to FighterProgression(
                actionSurgeUses = 1,
                indomitableUses = 0
            ),
            9 to FighterProgression(
                actionSurgeUses = 1,
                indomitableUses = 1
            ),
            13 to FighterProgression(
                actionSurgeUses = 1,
                indomitableUses = 2
            ),
            17 to FighterProgression(
                actionSurgeUses = 2,
                indomitableUses = 3
            )
        )
    )

    val monk = Monk(
        id = 7L,
        featureIds = emptyMap(),
        martialArtsProgression = mapOf(
            1 to MonkProgression(martialArtsDie = 4, kiPoints = 0),
            2 to MonkProgression(martialArtsDie = 4, kiPoints = 2),
            5 to MonkProgression(martialArtsDie = 6, kiPoints = 5),
            11 to MonkProgression(martialArtsDie = 8, kiPoints = 11),
            17 to MonkProgression(martialArtsDie = 10, kiPoints = 17)
        )
    )

    val paladin = Paladin(
        id = 8L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.CHA,
            cantripProgression = emptyMap(),
            spellSlotProgression = mapOf(
                2 to SpellSlotProgression(mapOf(1 to 2)),
                3 to SpellSlotProgression(mapOf(1 to 3)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                9 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = emptyMap()
        ),
        fightingStyleIds = emptyList(),
        layOnHands = mapOf(
            1 to LayOnHandsProgression(pool = 5),
            2 to LayOnHandsProgression(pool = 10),
            5 to LayOnHandsProgression(pool = 25),
            10 to LayOnHandsProgression(pool = 50),
            20 to LayOnHandsProgression(pool = 100)
        )
    )

    val ranger = Ranger(
        id = 9L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.WIS,
            cantripProgression = emptyMap(),
            spellSlotProgression = mapOf(
                2 to SpellSlotProgression(mapOf(1 to 2)),
                3 to SpellSlotProgression(mapOf(1 to 3)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                9 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = mapOf(
                2 to 2,
                3 to 3,
                5 to 4,
                9 to 6
            )
        ),
        fightingStyleIds = emptyList()
    )

    val rogue = Rogue(
        id = 10L,
        featureIds = emptyMap(),
        sneakAttack = mapOf(
            1 to SneakAttackProgression(dice = 1),
            3 to SneakAttackProgression(dice = 2),
            5 to SneakAttackProgression(dice = 3),
            7 to SneakAttackProgression(dice = 4),
            9 to SneakAttackProgression(dice = 5),
            11 to SneakAttackProgression(dice = 6),
            13 to SneakAttackProgression(dice = 7),
            15 to SneakAttackProgression(dice = 8),
            17 to SneakAttackProgression(dice = 9),
            19 to SneakAttackProgression(dice = 10)
        )
    )

    val sorcerer = Sorcerer(
        id = 11L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.CHA,
            cantripProgression = mapOf(
                1 to CantripProgression(4),
                4 to CantripProgression(5),
                10 to CantripProgression(6)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 3)),
                3 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = mapOf(
                1 to 2,
                2 to 3,
                3 to 4,
                5 to 6
            )
        ),
        sorceryPoints = mapOf(
            2 to SorceryPointProgression(points = 2),
            3 to SorceryPointProgression(points = 3),
            5 to SorceryPointProgression(points = 5),
            10 to SorceryPointProgression(points = 10),
            20 to SorceryPointProgression(points = 20)
        ),
        metamagics = listOf(
            Metamagic(
                name = "Quickened Spell",
                description = "You can change the casting time of a spell to a bonus action."
            ),
            Metamagic(
                name = "Twinned Spell",
                description = "You can target an additional eligible creature with a spell."
            )
        )
    )

    val warlock = Warlock(
        id = 12L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.CHA,
            cantripProgression = mapOf(
                1 to CantripProgression(2),
                4 to CantripProgression(3),
                10 to CantripProgression(4)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 1)),
                2 to SpellSlotProgression(mapOf(1 to 2)),
                3 to SpellSlotProgression(mapOf(2 to 2)),
                5 to SpellSlotProgression(mapOf(3 to 2)),
                11 to SpellSlotProgression(mapOf(5 to 3))
            ),
            spellsKnown = mapOf(
                1 to 2,
                2 to 3,
                3 to 4,
                5 to 6
            )
        ),
        eldritchInvocations = listOf(
            EldritchInvocation(
                name = "Agonizing Blast",
                description = "Add your Charisma modifier to the damage of Eldritch Blast."
            ),
            EldritchInvocation(
                name = "Devil's Sight",
                description = "You can see normally in darkness, both magical and nonmagical."
            )
        ),
        eldritchInvocationsKnown = mapOf(
            2 to EldritchInvocationsKnownProgression(known = 2),
            5 to EldritchInvocationsKnownProgression(known = 3),
            7 to EldritchInvocationsKnownProgression(known = 4),
            9 to EldritchInvocationsKnownProgression(known = 5),
            12 to EldritchInvocationsKnownProgression(known = 6),
            15 to EldritchInvocationsKnownProgression(known = 8),
            18 to EldritchInvocationsKnownProgression(known = 8)
        )
    )

    val wizard = Wizard(
        id = 13L,
        featureIds = emptyMap(),
        spellcasting = Spellcasting(
            spellcastingAbility = AbilityScores.INT,
            cantripProgression = mapOf(
                1 to CantripProgression(3),
                4 to CantripProgression(4),
                10 to CantripProgression(5)
            ),
            spellSlotProgression = mapOf(
                1 to SpellSlotProgression(mapOf(1 to 2)),
                2 to SpellSlotProgression(mapOf(1 to 3)),
                3 to SpellSlotProgression(mapOf(1 to 4, 2 to 2)),
                5 to SpellSlotProgression(mapOf(1 to 4, 2 to 3, 3 to 2))
            ),
            spellsKnown = emptyMap()
        )
    )

    val all = listOf(
        artificer,
        barbarian,
        bard,
        cleric,
        druid,
        fighter,
        monk,
        paladin,
        ranger,
        rogue,
        sorcerer,
        warlock,
        wizard
    )
}
