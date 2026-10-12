package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpellRepository(
    private val spellDao: SpellDao
) {

    suspend fun getAll(): List<Spell> =
        spellDao.getAll().map { it.toDomain() }

    suspend fun getByName(name: String): Spell? =
        spellDao.getByName(name)?.toDomain()
}