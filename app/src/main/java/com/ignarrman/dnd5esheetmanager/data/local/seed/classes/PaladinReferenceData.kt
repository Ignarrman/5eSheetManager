package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.LayOnHandsProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object PaladinReferenceData {

    const val CLASS_ID = 8L
    const val FEATURE_STARTING_ID = 8001L

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-paladin.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }

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