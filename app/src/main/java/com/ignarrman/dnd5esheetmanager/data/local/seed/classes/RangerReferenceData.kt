package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object RangerReferenceData {

    const val CLASS_ID = 9L

    val features = listOf(
        FeatureEntity(9001L, "Favored Enemy", "You have significant experience studying, tracking, hunting, and even talking to a certain type of enemy."),
        FeatureEntity(9002L, "Natural Explorer", "You are particularly familiar with one type of natural environment and are adept at traveling and surviving in such regions."),
        FeatureEntity(9003L, "Fighting Style", "You adopt a particular style of fighting as your specialty."),
        FeatureEntity(9004L, "Spellcasting", "You have learned to use the magical essence of nature to cast spells."),
        FeatureEntity(9005L, "Ranger Archetype", "You choose an archetype that you strive to emulate."),
        FeatureEntity(9006L, "Primeval Awareness", "You can use your action and expend one ranger spell slot to focus your awareness on the region around you."),
        FeatureEntity(9007L, "Ability Score Improvement", "You can increase one ability score of your choice."),
        FeatureEntity(9008L, "Extra Attack", "You can attack twice, instead of once, whenever you take the Attack action on your turn."),
        FeatureEntity(9009L, "Land's Stride", "Moving through nonmagical difficult terrain costs you no extra movement."),
        FeatureEntity(9010L, "Hide in Plain Sight", "You can spend 1 minute creating camouflage for yourself."),
        FeatureEntity(9011L, "Vanish", "You can use the Hide action as a bonus action on your turn."),
        FeatureEntity(9012L, "Feral Senses", "You gain preternatural senses that help you fight creatures you can't see."),
        FeatureEntity(9013L, "Foe Slayer", "You become an unparalleled hunter of your enemies.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 9001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 9002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 9003L, 2),
        ClassFeatureCrossRef(CLASS_ID, 9004L, 2),
        ClassFeatureCrossRef(CLASS_ID, 9005L, 3),
        ClassFeatureCrossRef(CLASS_ID, 9006L, 3),

        ClassFeatureCrossRef(CLASS_ID, 9007L, 4),
        ClassFeatureCrossRef(CLASS_ID, 9007L, 8),
        ClassFeatureCrossRef(CLASS_ID, 9007L, 12),
        ClassFeatureCrossRef(CLASS_ID, 9007L, 16),
        ClassFeatureCrossRef(CLASS_ID, 9007L, 19),

        ClassFeatureCrossRef(CLASS_ID, 9008L, 5),
        ClassFeatureCrossRef(CLASS_ID, 9009L, 8),
        ClassFeatureCrossRef(CLASS_ID, 9010L, 10),
        ClassFeatureCrossRef(CLASS_ID, 9011L, 14),
        ClassFeatureCrossRef(CLASS_ID, 9012L, 18),
        ClassFeatureCrossRef(CLASS_ID, 9013L, 20)
    )

    val fightingStyles = listOf(
        FightingStyleEntity(90001L, "Archery", "You gain a +2 bonus to attack rolls you make with ranged weapons."),
        FightingStyleEntity(90002L, "Defense", "While you are wearing armor, you gain a +1 bonus to AC."),
        FightingStyleEntity(90003L, "Dueling", "When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls."),
        FightingStyleEntity(90004L, "Two-Weapon Fighting", "When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.")
    )

    val fightingStyleRelations = fightingStyles.map {
        ClassFightingStyleCrossRef(
            classId = CLASS_ID,
            fightingStyleId = it.id
        )
    }

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "WIS"
    )

    val cantrips = emptyList<CantripProgressionEntity>()

    val spellsKnown = listOf(
        SpellsKnownProgressionEntity(CLASS_ID, 1, 0),
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

    val spellSlots = halfCasterSpellSlots(
        classId = CLASS_ID,
        startLevel = 2
    )
}