package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ClassFeatureJsonParser
import com.ignarrman.dnd5esheetmanager.data.local.seed.helpers.ParsedFeature

object WizardReferenceData {

    const val CLASS_ID = 13L
    const val FEATURE_STARTING_ID = 13001L

    fun getFeatures(
        context: Context
    ): List<ParsedFeature> {

        return ClassFeatureJsonParser.parse(
            context = context,
            fileName = "class-wizard.json",
            startingId = ArtificerReferenceData.FEATURE_STARTING_ID
        )
    }

    val spellcasting = SpellcastingEntity(
        classId = CLASS_ID,
        spellcastingAbility = "INT"
    )

    val cantrips = listOf(
        (1..3).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 3
            )
        },
        (4..9).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 4
            )
        },
        (10..20).map { level ->
            CantripProgressionEntity(
                classId = CLASS_ID,
                level = level,
                known = 5
            )
        }
    ).flatten()

    val spellsKnown = emptyList<SpellsKnownProgressionEntity>()

    val spellSlots = fullCasterSpellSlots(
        classId = CLASS_ID
    )
}