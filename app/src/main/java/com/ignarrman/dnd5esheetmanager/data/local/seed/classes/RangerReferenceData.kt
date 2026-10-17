package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedLevelFeature

object RangerReferenceData {

    const val CLASS_ID = 9L
    const val FEATURE_STARTING_ID = 9001L

    fun getFeatures(
        context: Context
    ): List<ParsedLevelFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-ranger.json",
            startingId = FEATURE_STARTING_ID
        )
    }

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

    val spellSlots = halfCasterSpellSlots(
        classId = CLASS_ID,
        startLevel = 2
    )
}