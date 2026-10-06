package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object FighterReferenceData {

    const val CLASS_ID = 6L
    const val FEATURE_STARTING_ID = 6001L

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

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-fighter.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }
}
