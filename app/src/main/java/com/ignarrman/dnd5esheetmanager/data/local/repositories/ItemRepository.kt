package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.ItemDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.data.mappers.toEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import javax.inject.Inject


class ItemRepository @Inject constructor(
    private val itemDao: ItemDao
) {

    suspend fun getByCharacterId(
        characterId: Long
    ): List<Item> {
        return itemDao
            .getByCharacterId(characterId)
            .map { it.toDomain() }
    }

    suspend fun insert(
        item: Item,
        characterId: Long
    ): Long {
        return itemDao.insert(
            item.toEntity(characterId)
        )
    }

    suspend fun deleteById(
        itemId: Long
    ) {
        itemDao.deleteById( itemId)
    }

    suspend fun deleteByCharacterId(
        characterId: Long
    ) {
        itemDao.deleteByCharacterId(characterId)
    }
}
