package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MetamagicEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SorceryPointProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedLevelFeature

object SorcererReferenceData {

    const val CLASS_ID = 11L
    const val FEATURE_STARTING_ID = 11001L

    fun getFeatures(
        context: Context
    ): List<ParsedLevelFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-sorcerer.json",
            startingId = FEATURE_STARTING_ID
        )
    }

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "CHA"
    )

    val spellSlots = fullCasterSpellSlots(
        classId = CLASS_ID
    )

    val sorceryPoints = (1..20).map { level ->
        SorceryPointProgressionEntity(
            level = level,
            points = if (level == 1) 0 else level
        )
    }

    val metamagics = listOf(
        MetamagicEntity(
            id = 11001L,
            name = "Careful Spell",
            description = "When you cast a spell that forces other creatures to make a saving throw, you can protect some of those creatures from the spell's full force."
        ),
        MetamagicEntity(
            id = 11002L,
            name = "Distant Spell",
            description = "When you cast a spell that has a range of 5 feet or greater, you can double the range of the spell."
        ),
        MetamagicEntity(
            id = 11003L,
            name = "Empowered Spell",
            description = "When you roll damage for a spell, you can spend 1 sorcery point to reroll a number of the damage dice."
        ),
        MetamagicEntity(
            id = 11004L,
            name = "Extended Spell",
            description = "When you cast a spell that has a duration of 1 minute or longer, you can double its duration."
        ),
        MetamagicEntity(
            id = 11005L,
            name = "Heightened Spell",
            description = "When you cast a spell that forces a creature to make a saving throw to resist its effects, you can spend 3 sorcery points to give one target of the spell disadvantage on its first saving throw."
        ),
        MetamagicEntity(
            id = 11006L,
            name = "Quickened Spell",
            description = "When you cast a spell that has a casting time of 1 action, you can spend 2 sorcery points to change the casting time to 1 bonus action."
        ),
        MetamagicEntity(
            id = 11007L,
            name = "Subtle Spell",
            description = "When you cast a spell, you can spend 1 sorcery point to cast it without any somatic or verbal components."
        ),
        MetamagicEntity(
            id = 11008L,
            name = "Twinned Spell",
            description = "When you cast a spell that targets only one creature and doesn't have a range of self, you can spend sorcery points to target a second creature."
        )
    )
}