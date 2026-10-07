package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.ItemDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.data.mappers.toEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item

class ItemRepository {

    class ItemRepository(
        private val itemDao: ItemDao
    ) {

        suspend fun getByCharacterId(
            characterId: Long
        ): List<Item> {
            return itemDao
                .getByCharacterId(characterId)
                .map { it.toDomain() }
        }

        suspend fun getById(
            id: Long
        ): Item? {
            return itemDao
                .getById(id)
                ?.toDomain()
        }

        suspend fun insert(
            item: Item,
            characterId: Long
        ): Long {
            return itemDao.insert(
                item.toEntity(characterId)
            )
        }

        suspend fun update(
            item: Item,
            characterId: Long
        ) {
            itemDao.update(
                item.toEntity(characterId)
            )
        }

        suspend fun delete(
            item: Item,
            characterId: Long
        ) {
            itemDao.delete(
                item.toEntity(characterId)
            )
        }

        suspend fun deleteByCharacterId(
            characterId: Long
        ) {
            itemDao.deleteByCharacterId(characterId)
        }
    }
}