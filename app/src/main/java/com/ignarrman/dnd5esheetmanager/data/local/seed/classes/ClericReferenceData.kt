package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ChannelDivinityProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

object ClericReferenceData {

    const val CLASS_ID = 4L

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

    val spellSlots = listOf(
        SpellSlotProgressionEntity(CLASS_ID, 1, 1, 2),

        SpellSlotProgressionEntity(CLASS_ID, 2, 1, 3),

        SpellSlotProgressionEntity(CLASS_ID, 3, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 3, 2, 2),

        SpellSlotProgressionEntity(CLASS_ID, 4, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 4, 2, 3),

        SpellSlotProgressionEntity(CLASS_ID, 5, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 5, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 5, 3, 2),

        SpellSlotProgressionEntity(CLASS_ID, 6, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 6, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 6, 3, 3),

        SpellSlotProgressionEntity(CLASS_ID, 7, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 7, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 7, 4, 1),

        SpellSlotProgressionEntity(CLASS_ID, 8, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 8, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 8, 4, 2),

        SpellSlotProgressionEntity(CLASS_ID, 9, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 9, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 9, 5, 1),

        SpellSlotProgressionEntity(CLASS_ID, 10, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 10, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 10, 5, 2),

        SpellSlotProgressionEntity(CLASS_ID, 11, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 11, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 11, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 11, 6, 1),

        SpellSlotProgressionEntity(CLASS_ID, 12, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 12, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 12, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 12, 6, 1),

        SpellSlotProgressionEntity(CLASS_ID, 13, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 13, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 13, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 13, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 13, 7, 1),

        SpellSlotProgressionEntity(CLASS_ID, 14, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 14, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 14, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 14, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 14, 7, 1),

        SpellSlotProgressionEntity(CLASS_ID, 15, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 15, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 15, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 15, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 15, 8, 1),

        SpellSlotProgressionEntity(CLASS_ID, 16, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 16, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 16, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 16, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 16, 8, 1),

        SpellSlotProgressionEntity(CLASS_ID, 17, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 17, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 17, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 17, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 17, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 18, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 18, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 18, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 18, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 18, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 19, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 19, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 19, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 19, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 19, 9, 1),

        SpellSlotProgressionEntity(CLASS_ID, 20, 1, 4),
        SpellSlotProgressionEntity(CLASS_ID, 20, 2, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 3, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 4, 3),
        SpellSlotProgressionEntity(CLASS_ID, 20, 5, 2),
        SpellSlotProgressionEntity(CLASS_ID, 20, 6, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 7, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 8, 1),
        SpellSlotProgressionEntity(CLASS_ID, 20, 9, 1)
    )

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

    val features = listOf(
        FeatureEntity(4001L, "Spellcasting", "Allows the cleric to cast divine spells using Wisdom as the spellcasting ability."),
        FeatureEntity(4002L, "Divine Domain", "Provides a divine domain with additional features and domain spells."),
        FeatureEntity(4003L, "Channel Divinity", "Allows the cleric to channel divine power for special effects granted by the class and domain."),
        FeatureEntity(4004L, "Ability Score Improvement", "Allows the cleric to improve ability scores or select a feat."),
        FeatureEntity(4005L, "Destroy Undead", "Allows Channel Divinity to destroy undead creatures below the appropriate challenge threshold."),
        FeatureEntity(4006L, "Divine Intervention", "Allows the cleric to call upon their deity for aid.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 4001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 4002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 4003L, 2),
        ClassFeatureCrossRef(CLASS_ID, 4004L, 4),
        ClassFeatureCrossRef(CLASS_ID, 4004L, 8),
        ClassFeatureCrossRef(CLASS_ID, 4004L, 12),
        ClassFeatureCrossRef(CLASS_ID, 4004L, 16),
        ClassFeatureCrossRef(CLASS_ID, 4005L, 5),
        ClassFeatureCrossRef(CLASS_ID, 4005L, 8),
        ClassFeatureCrossRef(CLASS_ID, 4005L, 11),
        ClassFeatureCrossRef(CLASS_ID, 4005L, 14),
        ClassFeatureCrossRef(CLASS_ID, 4006L, 10),
        ClassFeatureCrossRef(CLASS_ID, 4006L, 20)
    )
}