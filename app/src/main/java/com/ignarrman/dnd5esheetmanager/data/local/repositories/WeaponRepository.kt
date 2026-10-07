package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.WeaponDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.data.mappers.toEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon

class WeaponRepository(
    private val weaponDao: WeaponDao
) {

    suspend fun getByCharacterId(
        characterId: Long
    ): List<Weapon> {
        return weaponDao
            .getByCharacterId(characterId)
            .map { it.toDomain() }
    }

    suspend fun getById(
        id: Long
    ): Weapon? {
        return weaponDao
            .getById(id)
            ?.toDomain()
    }

    suspend fun insert(
        weapon: Weapon,
        characterId: Long
    ): Long {
        return weaponDao.insert(
            weapon.toEntity(characterId)
        )
    }

    suspend fun update(
        weapon: Weapon,
        characterId: Long
    ) {
        weaponDao.update(
            weapon.toEntity(characterId)
        )
    }

    suspend fun delete(
        weapon: Weapon,
        characterId: Long
    ) {
        weaponDao.delete(
            weapon.toEntity(characterId)
        )
    }

    suspend fun deleteByCharacterId(
        characterId: Long
    ) {
        weaponDao.deleteByCharacterId(characterId)
    }
}