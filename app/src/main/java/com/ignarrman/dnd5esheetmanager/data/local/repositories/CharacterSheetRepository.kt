package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.CharacterSheetDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao
) {

    suspend fun getAllCharacters(): List<CharacterSheet> {
        return characterSheetDao.getAll().map { it.toDomain() }
    }

    suspend fun getCharacterById(id: Long): CharacterSheet? {
        return characterSheetDao.getById(id)?.toDomain()
    }

}