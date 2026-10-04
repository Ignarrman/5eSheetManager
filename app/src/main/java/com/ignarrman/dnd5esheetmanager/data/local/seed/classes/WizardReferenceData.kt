package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object WizardReferenceData {

    const val CLASS_ID = 13L

    val features = listOf(
        FeatureEntity(
            id = 13001L,
            name = "Spellcasting",
            description = "As a student of arcane magic, you have a spellbook containing spells that show the first glimmerings of your true power."
        ),
        FeatureEntity(
            id = 13002L,
            name = "Arcane Recovery",
            description = "You have learned to regain some of your magical energy by studying your spellbook."
        ),
        FeatureEntity(
            id = 13003L,
            name = "Arcane Tradition",
            description = "You choose an arcane tradition, shaping your practice of magic through one of several schools of magic."
        ),
        FeatureEntity(
            id = 13004L,
            name = "Ability Score Improvement",
            description = "You can increase one ability score of your choice."
        ),
        FeatureEntity(
            id = 13005L,
            name = "Spell Mastery",
            description = "You have achieved such mastery over certain spells that you can cast them at will."
        ),
        FeatureEntity(
            id = 13006L,
            name = "Signature Spells",
            description = "You have achieved such mastery over certain spells that you can cast them with little effort."
        )
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 13001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 13002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 13003L, 2),

        ClassFeatureCrossRef(CLASS_ID, 13004L, 4),
        ClassFeatureCrossRef(CLASS_ID, 13004L, 8),
        ClassFeatureCrossRef(CLASS_ID, 13004L, 12),
        ClassFeatureCrossRef(CLASS_ID, 13004L, 16),
        ClassFeatureCrossRef(CLASS_ID, 13004L, 19),

        ClassFeatureCrossRef(CLASS_ID, 13005L, 18),
        ClassFeatureCrossRef(CLASS_ID, 13006L, 20)
    )

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "INT"
    )

    val cantrips = listOf(
        (1..3).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 3
            )
        },
        (4..9).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 4
            )
        },
        (10..20).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 5
            )
        }
    ).flatten()

    val spellsKnown = emptyList<SpellsKnownProgressionEntity>()

    val spellSlots = fullCasterSpellSlots(
        classId = CLASS_ID
    )
}