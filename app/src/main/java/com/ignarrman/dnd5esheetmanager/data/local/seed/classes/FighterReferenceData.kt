package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity

object FighterReferenceData {

    const val CLASS_ID = 6L

    val fightingStyles = listOf(
        FightingStyleEntity(
            id = 6001L,
            name = "Archery",
            description = "Provides a bonus to attack rolls made with ranged weapons."
        ),
        FightingStyleEntity(
            id = 6002L,
            name = "Defense",
            description = "Provides a bonus to Armor Class while wearing armor."
        ),
        FightingStyleEntity(
            id = 6003L,
            name = "Dueling",
            description = "Provides a bonus to damage when fighting with a single one-handed weapon under the required conditions."
        ),
        FightingStyleEntity(
            id = 6004L,
            name = "Great Weapon Fighting",
            description = "Allows certain weapon damage dice to be rerolled when using a qualifying heavy weapon."
        ),
        FightingStyleEntity(
            id = 6005L,
            name = "Protection",
            description = "Allows the fighter to impose disadvantage on an attack against a nearby ally while using a shield."
        ),
        FightingStyleEntity(
            id = 6006L,
            name = "Two-Weapon Fighting",
            description = "Allows the fighter to add the ability modifier to the damage of the second weapon attack."
        )
    )

    val fightingStyleRelations = listOf(
        ClassFightingStyleCrossRef(CLASS_ID, 6001L),
        ClassFightingStyleCrossRef(CLASS_ID, 6002L),
        ClassFightingStyleCrossRef(CLASS_ID, 6003L),
        ClassFightingStyleCrossRef(CLASS_ID, 6004L),
        ClassFightingStyleCrossRef(CLASS_ID, 6005L),
        ClassFightingStyleCrossRef(CLASS_ID, 6006L)
    )

    val progression = listOf(
        FighterProgressionEntity(1, 0, 0),
        FighterProgressionEntity(2, 1, 0),
        FighterProgressionEntity(3, 1, 0),
        FighterProgressionEntity(4, 1, 0),
        FighterProgressionEntity(5, 1, 0),
        FighterProgressionEntity(6, 1, 0),
        FighterProgressionEntity(7, 1, 0),
        FighterProgressionEntity(8, 1, 0),
        FighterProgressionEntity(9, 1, 0),
        FighterProgressionEntity(10, 1, 0),
        FighterProgressionEntity(11, 2, 0),
        FighterProgressionEntity(12, 2, 0),
        FighterProgressionEntity(13, 2, 0),
        FighterProgressionEntity(14, 2, 1),
        FighterProgressionEntity(15, 2, 1),
        FighterProgressionEntity(16, 2, 1),
        FighterProgressionEntity(17, 2, 1),
        FighterProgressionEntity(18, 2, 1),
        FighterProgressionEntity(19, 2, 1),
        FighterProgressionEntity(20, 2, 1)
    )

    val features = listOf(
        FeatureEntity(
            id = 6101L,
            name = "Fighting Style",
            description = "Allows the fighter to adopt a specialized combat style."
        ),
        FeatureEntity(
            id = 6102L,
            name = "Second Wind",
            description = "Allows the fighter to recover hit points as a bonus action."
        ),
        FeatureEntity(
            id = 6103L,
            name = "Action Surge",
            description = "Allows the fighter to take an additional action on their turn."
        ),
        FeatureEntity(
            id = 6104L,
            name = "Martial Archetype",
            description = "Provides a fighter subclass and its associated features."
        ),
        FeatureEntity(
            id = 6105L,
            name = "Ability Score Improvement",
            description = "Allows the fighter to improve ability scores or select a feat."
        ),
        FeatureEntity(
            id = 6106L,
            name = "Extra Attack",
            description = "Allows the fighter to make additional attacks when taking the Attack action."
        ),
        FeatureEntity(
            id = 6107L,
            name = "Indomitable",
            description = "Allows the fighter to reroll a failed saving throw."
        )
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 6101L, 1),
        ClassFeatureCrossRef(CLASS_ID, 6102L, 1),
        ClassFeatureCrossRef(CLASS_ID, 6103L, 2),
        ClassFeatureCrossRef(CLASS_ID, 6104L, 3),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 4),
        ClassFeatureCrossRef(CLASS_ID, 6106L, 5),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 6),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 8),
        ClassFeatureCrossRef(CLASS_ID, 6107L, 9),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 12),
        ClassFeatureCrossRef(CLASS_ID, 6106L, 11),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 14),
        ClassFeatureCrossRef(CLASS_ID, 6107L, 13),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 16),
        ClassFeatureCrossRef(CLASS_ID, 6107L, 17),
        ClassFeatureCrossRef(CLASS_ID, 6107L, 18),
        ClassFeatureCrossRef(CLASS_ID, 6105L, 19),
        ClassFeatureCrossRef(CLASS_ID, 6106L, 20)
    )
}
