package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object WarlockReferenceData {

    const val CLASS_ID = 12L
    const val FEATURE_STARTING_ID = 12001L

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-warlock.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "CHA"
    )

    val cantrips = listOf(
        (1..3).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 2
            )
        },
        (4..20).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 3
            )
        }
    ).flatten()

    val spellsKnown = listOf(
        1 to 2,
        2 to 3,
        3 to 4,
        4 to 5,
        5 to 6,
        6 to 7,
        7 to 8,
        8 to 9,
        9 to 10,
        10 to 10,
        11 to 11,
        12 to 11,
        13 to 12,
        14 to 12,
        15 to 13,
        16 to 13,
        17 to 14,
        18 to 14,
        19 to 15,
        20 to 15
    ).map { (level, known) ->
        SpellsKnownProgressionEntity(
            classId = CLASS_ID,
            level = level,
            known = known
        )
    }

    val spellSlots = pactMagicSpellSlots(
        classId = CLASS_ID
    )

    val eldritchInvocationsKnown = listOf(
        2 to 2,
        5 to 3,
        7 to 4,
        9 to 5,
        12 to 6,
        15 to 7,
        18 to 8
    ).map { (level, known) ->
        EldritchInvocationsKnownProgressionEntity(
            level = level,
            known = known
        )
    }

    val eldritchInvocations = listOf(
        EldritchInvocationsEntity(
            level = 2,
            name = "Agonizing Blast",
            description = "When you cast eldritch blast, add your Charisma modifier to the damage it deals on a hit."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Armor of Shadows",
            description = "You can cast mage armor on yourself at will, without expending a spell slot or material components."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Beast Speech",
            description = "You can cast speak with animals at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Beguiling Influence",
            description = "You gain proficiency in the Deception and Persuasion skills."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Bewitching Whispers",
            description = "You can cast compulsion once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Book of Ancient Secrets",
            description = "You can inscribe magical rituals in your Book of Shadows."
        ),
        EldritchInvocationsEntity(
            level = 15,
            name = "Chains of Carceri",
            description = "You can cast hold monster at will, targeting a celestial, fiend, or elemental, without expending a spell slot or material components."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Devil's Sight",
            description = "You can see normally in darkness, both magical and nonmagical, to a distance of 120 feet."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Dreadful Word",
            description = "You can cast confusion once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Eldritch Sight",
            description = "You can cast detect magic at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Eldritch Spear",
            description = "When you cast eldritch blast, its range is 300 feet."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Eyes of the Rune Keeper",
            description = "You can read all writing."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Fiendish Vigor",
            description = "You can cast false life on yourself at will as a 1st-level spell, without expending a spell slot or material components."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Gaze of Two Minds",
            description = "You can use your action to touch a willing humanoid and perceive through its senses."
        ),
        EldritchInvocationsEntity(
            level = 12,
            name = "Lifedrinker",
            description = "When you hit a creature with your pact weapon, the creature takes extra necrotic damage."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Mask of Many Faces",
            description = "You can cast disguise self at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 15,
            name = "Master of Myriad Forms",
            description = "You can cast alter self at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 9,
            name = "Minions of Chaos",
            description = "You can cast conjure elemental once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Mire the Mind",
            description = "You can cast slow once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Misty Visions",
            description = "You can cast silent image at will, without expending a spell slot or material components."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "One with Shadows",
            description = "When you are in an area of dim light or darkness, you can use your action to become invisible until you move or take an action or reaction."
        ),
        EldritchInvocationsEntity(
            level = 9,
            name = "Otherworldly Leap",
            description = "You can cast jump on yourself at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Repelling Blast",
            description = "When you hit a creature with eldritch blast, you can push the creature up to 10 feet away from you in a straight line."
        ),
        EldritchInvocationsEntity(
            level = 7,
            name = "Sculptor of Flesh",
            description = "You can cast polymorph once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Sign of Ill Omen",
            description = "You can cast bestow curse once using a warlock spell slot. You can't do so again until you finish a long rest."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Thief of Five Fates",
            description = "You can cast bane once using a warlock spell slot."
        ),
        EldritchInvocationsEntity(
            level = 5,
            name = "Thirsting Blade",
            description = "You can attack twice with your pact weapon whenever you take the Attack action on your turn."
        ),
        EldritchInvocationsEntity(
            level = 15,
            name = "Visions of Distant Realms",
            description = "You can cast arcane eye at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 2,
            name = "Voice of the Chain Master",
            description = "You can communicate telepathically with your familiar and perceive through its senses."
        ),
        EldritchInvocationsEntity(
            level = 15,
            name = "Whispers of the Grave",
            description = "You can cast speak with dead at will, without expending a spell slot."
        ),
        EldritchInvocationsEntity(
            level = 15,
            name = "Witch Sight",
            description = "You can see the true form of any shapechanger or creature concealed by illusion or transmutation magic."
        )
    )
}