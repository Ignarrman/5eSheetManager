package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object ArtificerReferenceData {

    const val CLASS_ID = 3L
    const val FEATURE_STARTING_ID = 3001L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "INT"
    )

    val cantrips = listOf(
        CantripProgressionEntity(CLASS_ID, 1, 2),
        CantripProgressionEntity(CLASS_ID, 2, 2),
        CantripProgressionEntity(CLASS_ID, 3, 2),
        CantripProgressionEntity(CLASS_ID, 4, 2),
        CantripProgressionEntity(CLASS_ID, 5, 2),
        CantripProgressionEntity(CLASS_ID, 6, 2),
        CantripProgressionEntity(CLASS_ID, 7, 2),
        CantripProgressionEntity(CLASS_ID, 8, 2),
        CantripProgressionEntity(CLASS_ID, 9, 2),
        CantripProgressionEntity(CLASS_ID, 10, 3),
        CantripProgressionEntity(CLASS_ID, 11, 3),
        CantripProgressionEntity(CLASS_ID, 12, 3),
        CantripProgressionEntity(CLASS_ID, 13, 3),
        CantripProgressionEntity(CLASS_ID, 14, 3),
        CantripProgressionEntity(CLASS_ID, 15, 3),
        CantripProgressionEntity(CLASS_ID, 16, 3),
        CantripProgressionEntity(CLASS_ID, 17, 4),
        CantripProgressionEntity(CLASS_ID, 18, 4),
        CantripProgressionEntity(CLASS_ID, 19, 4),
        CantripProgressionEntity(CLASS_ID, 20, 4)
    )

    val spellsKnown = listOf(
        SpellsKnownProgressionEntity(CLASS_ID, 1, 2),
        SpellsKnownProgressionEntity(CLASS_ID, 2, 2),
        SpellsKnownProgressionEntity(CLASS_ID, 3, 3),
        SpellsKnownProgressionEntity(CLASS_ID, 4, 3),
        SpellsKnownProgressionEntity(CLASS_ID, 5, 4),
        SpellsKnownProgressionEntity(CLASS_ID, 6, 4),
        SpellsKnownProgressionEntity(CLASS_ID, 7, 5),
        SpellsKnownProgressionEntity(CLASS_ID, 8, 5),
        SpellsKnownProgressionEntity(CLASS_ID, 9, 6),
        SpellsKnownProgressionEntity(CLASS_ID, 10, 6),
        SpellsKnownProgressionEntity(CLASS_ID, 11, 7),
        SpellsKnownProgressionEntity(CLASS_ID, 12, 7),
        SpellsKnownProgressionEntity(CLASS_ID, 13, 8),
        SpellsKnownProgressionEntity(CLASS_ID, 14, 8),
        SpellsKnownProgressionEntity(CLASS_ID, 15, 9),
        SpellsKnownProgressionEntity(CLASS_ID, 16, 9),
        SpellsKnownProgressionEntity(CLASS_ID, 17, 10),
        SpellsKnownProgressionEntity(CLASS_ID, 18, 10),
        SpellsKnownProgressionEntity(CLASS_ID, 19, 11),
        SpellsKnownProgressionEntity(CLASS_ID, 20, 11)
    )

    val spellSlots = halfCasterSpellSlots(CLASS_ID, startLevel = 1)

    val infusions = listOf(
        InfusionEntity(
            id = 3001L,
            name = "Arcane Propulsion Armor",
            description = "A suit of armor that increases the wearer's speed and provides magical gauntlets that deal force damage and can be thrown and returned."
        ),
        InfusionEntity(
            id = 3002L,
            name = "Armor of Magical Strength",
            description = "A suit of armor with charges that can improve Strength checks and saving throws or prevent the wearer from being knocked prone."
        ),
        InfusionEntity(
            id = 3003L,
            name = "Boots of the Winding Path",
            description = "A pair of boots that allow the wearer to teleport to a location where they have previously been during the current turn."
        ),
        InfusionEntity(
            id = 3004L,
            name = "Enhanced Arcane Focus",
            description = "A rod, staff, or wand that improves spell attack rolls and allows the wielder to ignore half cover when making a spell attack."
        ),
        InfusionEntity(
            id = 3005L,
            name = "Enhanced Defense",
            description = "Armor or a shield that grants a bonus to Armor Class."
        ),
        InfusionEntity(
            id = 3006L,
            name = "Enhanced Weapon",
            description = "A weapon that grants a bonus to attack and damage rolls."
        ),
        InfusionEntity(
            id = 3007L,
            name = "Helm of Awareness",
            description = "A magical helm that prevents the wearer from being surprised and grants advantage on initiative rolls."
        ),
        InfusionEntity(
            id = 3008L,
            name = "Homunculus Servant",
            description = "A magical construct that serves its creator and can act independently in combat."
        ),
        InfusionEntity(
            id = 3009L,
            name = "Mind Sharpener",
            description = "An item that allows its wearer to use charges to succeed on a Constitution saving throw made to maintain concentration."
        ),
        InfusionEntity(
            id = 3010L,
            name = "Radiant Weapon",
            description = "A weapon that grants a bonus to attack and damage rolls, sheds light, and can use charges to impose disadvantage on an attack made against its wielder."
        ),
        InfusionEntity(
            id = 3011L,
            name = "Repeating Shot",
            description = "A weapon that grants a bonus to ranged attack and damage rolls, ignores the loading property, and creates its own ammunition."
        ),
        InfusionEntity(
            id = 3012L,
            name = "Replicate Magic Item",
            description = "An infusion that allows the artificer to replicate a specific magic item from the available replicable item lists."
        ),
        InfusionEntity(
            id = 3013L,
            name = "Repulsion Shield",
            description = "A shield that improves Armor Class and can use charges to push a creature away when it hits the wielder with a melee attack."
        ),
        InfusionEntity(
            id = 3014L,
            name = "Resistant Armor",
            description = "Armor that grants resistance to one chosen damage type."
        ),
        InfusionEntity(
            id = 3015L,
            name = "Returning Weapon",
            description = "A weapon that grants a bonus to attack and damage rolls and returns to its wielder's hand immediately after being thrown."
        ),
        InfusionEntity(
            id = 3016L,
            name = "Spell-Refueling Ring",
            description = "A ring that allows its wearer to recover a spell slot after completing a long rest."
        )
    )

    val infusionProgression = listOf(
        InfusionProgressionEntity(2, 4, 2),
        InfusionProgressionEntity(3, 4, 2),
        InfusionProgressionEntity(4, 4, 2),
        InfusionProgressionEntity(5, 4, 2),
        InfusionProgressionEntity(6, 6, 2),
        InfusionProgressionEntity(7, 6, 3),
        InfusionProgressionEntity(8, 6, 3),
        InfusionProgressionEntity(9, 8, 4),
        InfusionProgressionEntity(10, 8, 4),
        InfusionProgressionEntity(11, 10, 4),
        InfusionProgressionEntity(12, 10, 4),
        InfusionProgressionEntity(13, 10, 5),
        InfusionProgressionEntity(14, 12, 5),
        InfusionProgressionEntity(15, 12, 6),
        InfusionProgressionEntity(16, 12, 6),
        InfusionProgressionEntity(17, 14, 7),
        InfusionProgressionEntity(18, 14, 7),
        InfusionProgressionEntity(19, 16, 8),
        InfusionProgressionEntity(20, 18, 8)
    )

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-artificer.json",
            startingId = FEATURE_STARTING_ID
        )
    }
}
