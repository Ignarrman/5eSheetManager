package com.ignarrman.dnd5esheetmanager.data.local.repositories

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSpellCrossRef
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpellRepository @Inject constructor(
    private val spellDao: SpellDao
) {

    suspend fun getAll(): List<Spell> {
        return spellDao.getAll().map { it.toDomain() }
    }


    suspend fun insertCharacterSpell(
        spell: Spell,
        characterId: Long
    ): Long {
        return spellDao.insertCharacterSpell(CharacterSpellCrossRef(characterId = characterId, spellId = spell.id!!))
    }

    suspend fun deleteCharacterSpell(
        spellId: Long,
        characterId: Long
    ) {
        spellDao.deleteByCharacterIdAndSpellId(characterId = characterId, spellId = spellId)
    }
}