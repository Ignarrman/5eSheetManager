package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SneakAttackProgressionEntity

object RogueReferenceData {

    const val CLASS_ID = 10L

    val features = listOf(
        FeatureEntity(10001L, "Expertise", "Your proficiency bonus is doubled for any ability check you make that uses either of your chosen proficiencies."),
        FeatureEntity(10002L, "Sneak Attack", "You know how to strike subtly and exploit a foe's distraction."),
        FeatureEntity(10003L, "Thieves' Cant", "You learned thieves' cant, a secret mix of dialect, jargon, and code."),
        FeatureEntity(10004L, "Cunning Action", "Your quick thinking and agility allow you to move and act quickly."),
        FeatureEntity(10005L, "Roguish Archetype", "You choose an archetype that you emulate in the exercise of your rogue abilities."),
        FeatureEntity(10006L, "Ability Score Improvement", "You can increase one ability score of your choice."),
        FeatureEntity(10007L, "Uncanny Dodge", "When an attacker that you can see hits you with an attack, you can use your reaction to halve the attack's damage."),
        FeatureEntity(10008L, "Evasion", "You can nimbly dodge out of the way of certain area effects."),
        FeatureEntity(10009L, "Reliable Talent", "Whenever you make an ability check that lets you add your proficiency bonus, you can treat a d20 roll of 9 or lower as a 10."),
        FeatureEntity(10010L, "Blindsense", "If you are able to hear, you are aware of the location of any hidden or invisible creature within 10 feet of you."),
        FeatureEntity(10011L, "Slippery Mind", "You gain proficiency in Wisdom saving throws."),
        FeatureEntity(10012L, "Elusive", "No attack roll has advantage against you while you aren't incapacitated."),
        FeatureEntity(10013L, "Stroke of Luck", "You have an uncanny knack for succeeding when you need to.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 10001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 10001L, 6),
        ClassFeatureCrossRef(CLASS_ID, 10002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 10003L, 1),
        ClassFeatureCrossRef(CLASS_ID, 10004L, 2),
        ClassFeatureCrossRef(CLASS_ID, 10005L, 3),

        ClassFeatureCrossRef(CLASS_ID, 10006L, 4),
        ClassFeatureCrossRef(CLASS_ID, 10006L, 8),
        ClassFeatureCrossRef(CLASS_ID, 10006L, 10),
        ClassFeatureCrossRef(CLASS_ID, 10006L, 12),
        ClassFeatureCrossRef(CLASS_ID, 10006L, 16),
        ClassFeatureCrossRef(CLASS_ID, 10006L, 19),

        ClassFeatureCrossRef(CLASS_ID, 10007L, 5),
        ClassFeatureCrossRef(CLASS_ID, 10008L, 7),
        ClassFeatureCrossRef(CLASS_ID, 10009L, 11),
        ClassFeatureCrossRef(CLASS_ID, 10010L, 14),
        ClassFeatureCrossRef(CLASS_ID, 10011L, 15),
        ClassFeatureCrossRef(CLASS_ID, 10012L, 18),
        ClassFeatureCrossRef(CLASS_ID, 10013L, 20)
    )

    val sneakAttackProgression = (1..20).map { level ->
        SneakAttackProgressionEntity(
            level = level,
            dice = (level + 1) / 2
        )
    }
}