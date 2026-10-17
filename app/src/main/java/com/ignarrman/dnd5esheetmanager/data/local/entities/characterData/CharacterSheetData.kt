package com.ignarrman.dnd5esheetmanager.data.local.entities.characterData

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundWithFeature
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceWithFeatures
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity

data class CharacterSheetData(
    val characterSheetEntity: CharacterSheetEntity,
    val race: RaceWithFeatures?,
    val background: BackgroundWithFeature?,
    val feats: List<FeatEntity>,
    val spells: List<SpellEntity>
)

data class CharacterSheetPersistence(
    val entity: CharacterSheetEntity,
    val featRelations: List<CharacterFeatCrossRef>,
    val spellRelations: List<CharacterSpellCrossRef>
)