package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef

object BarbarianReferenceData {

    const val CLASS_ID = 1L

    val progression = listOf(
        BarbarianProgressionEntity(
            level = 1,
            rageUses = 2,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 2,
            rageUses = 2,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 3,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 4,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 5,
            rageUses = 3,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 6,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 7,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 8,
            rageUses = 4,
            rageDamage = 2
        ),
        BarbarianProgressionEntity(
            level = 9,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 10,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 11,
            rageUses = 4,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 12,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 13,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 14,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 15,
            rageUses = 5,
            rageDamage = 3
        ),
        BarbarianProgressionEntity(
            level = 16,
            rageUses = 5,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 17,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 18,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 19,
            rageUses = 6,
            rageDamage = 4
        ),
        BarbarianProgressionEntity(
            level = 20,
            rageUses = 999,
            rageDamage = 4
        )
    )

    val features = listOf(
        FeatureEntity(
            id = 1001L,
            name = "Rage",
            description = "Allows the barbarian to enter a rage and gain its associated benefits."
        ),
        FeatureEntity(
            id = 1002L,
            name = "Unarmored Defense",
            description = "Provides an alternative way to determine Armor Class while not wearing armor."
        ),
        FeatureEntity(
            id = 1003L,
            name = "Reckless Attack",
            description = "Allows the barbarian to attack recklessly for increased attack accuracy at a cost."
        ),
        FeatureEntity(
            id = 1004L,
            name = "Danger Sense",
            description = "Improves the barbarian's ability to avoid certain visible effects."
        ),
        FeatureEntity(
            id = 1005L,
            name = "Extra Attack",
            description = "Allows the barbarian to make an additional attack when taking the Attack action."
        ),
        FeatureEntity(
            id = 1006L,
            name = "Fast Movement",
            description = "Increases movement speed while the barbarian is not wearing heavy armor."
        ),
        FeatureEntity(
            id = 1007L,
            name = "Feral Instinct",
            description = "Improves initiative and provides a way to act despite being surprised."
        ),
        FeatureEntity(
            id = 1008L,
            name = "Brutal Critical",
            description = "Allows additional weapon damage dice to be rolled on a critical hit."
        ),
        FeatureEntity(
            id = 1009L,
            name = "Relentless Rage",
            description = "Allows the barbarian to attempt to remain conscious when reduced to 0 hit points."
        ),
        FeatureEntity(
            id = 1010L,
            name = "Persistent Rage",
            description = "Makes it substantially harder for the barbarian's rage to end early."
        ),
        FeatureEntity(
            id = 1011L,
            name = "Indomitable Might",
            description = "Allows certain Strength checks to use the barbarian's Strength score instead of the rolled result."
        ),
        FeatureEntity(
            id = 1012L,
            name = "Primal Champion",
            description = "Improves the barbarian's Strength and Constitution maximums and scores."
        )
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1001L,
            level = 1
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1002L,
            level = 1
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1003L,
            level = 2
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1004L,
            level = 2
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1005L,
            level = 5
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1006L,
            level = 5
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1007L,
            level = 7
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1008L,
            level = 9
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1009L,
            level = 11
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1010L,
            level = 15
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1011L,
            level = 18
        ),
        ClassFeatureCrossRef(
            classId = CLASS_ID,
            featureId = 1012L,
            level = 20
        )
    )
}