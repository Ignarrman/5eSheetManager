package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.LayOnHandsProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object PaladinReferenceData {

    const val CLASS_ID = 8L

    val features = listOf(
        FeatureEntity(8001L, "Divine Sense", "The presence of strong evil registers on your senses like a noxious odor."),
        FeatureEntity(8002L, "Lay on Hands", "Your blessed touch can heal wounds."),
        FeatureEntity(8003L, "Fighting Style", "You adopt a particular style of fighting as your specialty."),
        FeatureEntity(8004L, "Spellcasting", "You have learned to draw on divine magic through meditation and prayer."),
        FeatureEntity(8005L, "Divine Smite", "When you hit a creature with a melee weapon attack, you can expend one spell slot to deal radiant damage."),
        FeatureEntity(8006L, "Divine Health", "The divine magic flowing through you makes you immune to disease."),
        FeatureEntity(8007L, "Sacred Oath", "You swear the oath that binds you as a paladin forever."),
        FeatureEntity(8008L, "Ability Score Improvement", "You can increase one ability score of your choice."),
        FeatureEntity(8009L, "Extra Attack", "You can attack twice, instead of once, whenever you take the Attack action on your turn."),
        FeatureEntity(8010L, "Aura of Protection", "Whenever you or a friendly creature within 10 feet of you must make a saving throw, the creature gains a bonus to the saving throw."),
        FeatureEntity(8011L, "Aura of Courage", "You and friendly creatures within 10 feet of you can't be frightened while you are conscious."),
        FeatureEntity(8012L, "Improved Divine Smite", "Whenever you hit a creature with a melee weapon, the creature takes extra radiant damage."),
        FeatureEntity(8013L, "Cleansing Touch", "You can use your action to end one spell on yourself or on one willing creature that you touch.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 8001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 8002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 8003L, 2),
        ClassFeatureCrossRef(CLASS_ID, 8004L, 2),
        ClassFeatureCrossRef(CLASS_ID, 8005L, 2),
        ClassFeatureCrossRef(CLASS_ID, 8006L, 3),
        ClassFeatureCrossRef(CLASS_ID, 8007L, 3),

        ClassFeatureCrossRef(CLASS_ID, 8008L, 4),
        ClassFeatureCrossRef(CLASS_ID, 8008L, 8),
        ClassFeatureCrossRef(CLASS_ID, 8008L, 12),
        ClassFeatureCrossRef(CLASS_ID, 8008L, 16),
        ClassFeatureCrossRef(CLASS_ID, 8008L, 19),

        ClassFeatureCrossRef(CLASS_ID, 8009L, 5),
        ClassFeatureCrossRef(CLASS_ID, 8010L, 6),
        ClassFeatureCrossRef(CLASS_ID, 8011L, 10),
        ClassFeatureCrossRef(CLASS_ID, 8012L, 11),
        ClassFeatureCrossRef(CLASS_ID, 8010L, 18),
        ClassFeatureCrossRef(CLASS_ID, 8013L, 14)
    )

    val fightingStyles = listOf(
        FightingStyleEntity(80001L, "Defense", "While you are wearing armor, you gain a +1 bonus to AC."),
        FightingStyleEntity(80002L, "Dueling", "When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls."),
        FightingStyleEntity(80003L, "Great Weapon Fighting", "When you roll a 1 or 2 on a damage die for an attack with a two-handed or versatile melee weapon, you can reroll the die."),
        FightingStyleEntity(80004L, "Protection", "When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll.")
    )

    val fightingStyleRelations = fightingStyles.map {
        ClassFightingStyleCrossRef(
            classId = CLASS_ID,
            fightingStyleId = it.id
        )
    }

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "CHA"
    )

    val cantrips = emptyList<CantripProgressionEntity>()

    val spellsKnown = emptyList<SpellsKnownProgressionEntity>()

    val spellSlots = halfCasterSpellSlots(
        classId = CLASS_ID,
        startLevel = 2
    )

    val layOnHandsProgression = (1..20).map { level ->
        LayOnHandsProgressionEntity(
            level = level,
            pool = level * 5
        )
    }
}