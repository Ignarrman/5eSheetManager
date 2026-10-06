package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ChannelDivinityProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object ClericReferenceData {

    const val CLASS_ID = 4L
    const val FEATURE_STARTING_ID = 4001L

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "WIS"
    )

    val cantrips = listOf(
        CantripProgressionEntity(CLASS_ID, 1, 3),
        CantripProgressionEntity(CLASS_ID, 2, 3),
        CantripProgressionEntity(CLASS_ID, 3, 3),
        CantripProgressionEntity(CLASS_ID, 4, 4),
        CantripProgressionEntity(CLASS_ID, 5, 4),
        CantripProgressionEntity(CLASS_ID, 6, 4),
        CantripProgressionEntity(CLASS_ID, 7, 4),
        CantripProgressionEntity(CLASS_ID, 8, 4),
        CantripProgressionEntity(CLASS_ID, 9, 4),
        CantripProgressionEntity(CLASS_ID, 10, 5),
        CantripProgressionEntity(CLASS_ID, 11, 5),
        CantripProgressionEntity(CLASS_ID, 12, 5),
        CantripProgressionEntity(CLASS_ID, 13, 5),
        CantripProgressionEntity(CLASS_ID, 14, 5),
        CantripProgressionEntity(CLASS_ID, 15, 5),
        CantripProgressionEntity(CLASS_ID, 16, 5),
        CantripProgressionEntity(CLASS_ID, 17, 5),
        CantripProgressionEntity(CLASS_ID, 18, 5),
        CantripProgressionEntity(CLASS_ID, 19, 5),
        CantripProgressionEntity(CLASS_ID, 20, 5)
    )

    val spellsKnown = emptyList<SpellsKnownProgressionEntity>()

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
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-cleric.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }
}