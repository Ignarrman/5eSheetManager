package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds.BackgroundDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.CharacterSheetDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao.FeatDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.races.RaceDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetData
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSpellCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundWithFeature
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceWithFeatures
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.data.mappers.toPersistence
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao,
    private val featDao: FeatDao,
    private val spellDao: SpellDao,
    private val backgroundDao: BackgroundDao,
    private val featureDao: FeatureDao,
    private val raceDao: RaceDao
) {

    suspend fun getAllCharacters(): List<CharacterSheet> {
        return characterSheetDao.getAll()
            .map { buildCharacterSheet(it) }
    }

    suspend fun getCharacterById(id: Long): CharacterSheet? {
        val entity = characterSheetDao.getById(id) ?: return null
        return buildCharacterSheet(entity)
    }

    suspend fun insert(
        character: CharacterSheet
    ): Long {

        val persistence = character.toPersistence()
        val characterId = characterSheetDao.insert(persistence.entity)

        featDao.insertAllCharacterRef(persistence.featRelations.map { it.copy(characterId = characterId) })
        spellDao.insertAllCharacterRef(persistence.spellRelations.map { it.copy(characterId = characterId) })

        return characterId
    }

    suspend fun update(
        character: CharacterSheet
    ) {

        val persistence = character.toPersistence()
        characterSheetDao.update(persistence.entity)

        featDao.deleteByCharacterId(character.id!!)
        spellDao.deleteByCharacterId(character.id)

        featDao.insertAllCharacterRef(persistence.featRelations)
        spellDao.insertAllCharacterRef(persistence.spellRelations)
    }


    suspend fun delete(
        characterId: Long
    ) {

        featDao.deleteByCharacterId(characterId)

        spellDao.deleteByCharacterId(characterId)

        characterSheetDao.deleteById(characterId)
    }

    private suspend fun buildCharacterSheet(
        entity: CharacterSheetEntity
    ): CharacterSheet {

        val featIds = featDao.getByCharacterId(entity.id)
            .map { it.featId }
        val feats = featDao.getByIds(featIds)

        val spellIds = spellDao.getByCharacterId(entity.id)
            .map { it.spellId }
        val spells = spellDao.getByIds(spellIds)

        val backgroundEntity =
            entity.backgroundId?.let {
                backgroundDao.getById(it)
            }

        val backgroundWithFeature =
            backgroundEntity?.let { background ->
                featureDao.getById(background.featureId)?.let { feature ->
                    BackgroundWithFeature(
                        background = background,
                        feature = feature
                    )
                }
            }

        val raceEntity =
            entity.raceId?.let {
                raceDao.getById(it)
            }

        val raceWithFeatures =
            raceEntity?.let { race ->
                RaceWithFeatures(
                    raceEntity = race,
                    features = raceDao.getFeaturesForRace(race.id)
                )
            }

        return CharacterSheetData(
            characterSheetEntity = entity,
            background = backgroundWithFeature,
            race = raceWithFeatures,
            feats = feats,
            spells = spells
        ).toDomain()
    }

}