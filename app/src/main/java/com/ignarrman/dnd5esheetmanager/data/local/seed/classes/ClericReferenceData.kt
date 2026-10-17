package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ChannelDivinityProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedLevelFeature

object ClericReferenceData {

    const val CLASS_ID = 4L
    const val FEATURE_STARTING_ID = 4001L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "WIS"
    )

    val spellSlots = fullCasterSpellSlots(CLASS_ID)

    val channelDivinityProgression = listOf(
        ChannelDivinityProgressionEntity(2, 1),
        ChannelDivinityProgressionEntity(3, 1),
        ChannelDivinityProgressionEntity(4, 1),
        ChannelDivinityProgressionEntity(5, 2),
        ChannelDivinityProgressionEntity(6, 2),
        ChannelDivinityProgressionEntity(7, 2),
        ChannelDivinityProgressionEntity(8, 2),
        ChannelDivinityProgressionEntity(9, 2),
        ChannelDivinityProgressionEntity(10, 2),
        ChannelDivinityProgressionEntity(11, 2),
        ChannelDivinityProgressionEntity(12, 2),
        ChannelDivinityProgressionEntity(13, 2),
        ChannelDivinityProgressionEntity(14, 2),
        ChannelDivinityProgressionEntity(15, 2),
        ChannelDivinityProgressionEntity(16, 2),
        ChannelDivinityProgressionEntity(17, 2),
        ChannelDivinityProgressionEntity(18, 3),
        ChannelDivinityProgressionEntity(19, 3),
        ChannelDivinityProgressionEntity(20, 3)
    )

    fun getFeatures(
        context: Context
    ): List<ParsedLevelFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-cleric.json",
            startingId = FEATURE_STARTING_ID
        )
    }
}