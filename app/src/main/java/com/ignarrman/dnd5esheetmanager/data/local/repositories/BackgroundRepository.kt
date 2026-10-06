package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds.BackgroundDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import javax.inject.Inject

class BackgroundRepository @Inject constructor(
    private val backgroundDao: BackgroundDao,
    ) {

    suspend fun getAll(): List<Background> {
        return backgroundDao
            .getAll()
            .map { it.toDomain() }
    }

}