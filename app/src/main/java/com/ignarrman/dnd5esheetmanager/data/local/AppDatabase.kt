package com.ignarrman.dnd5esheetmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ignarrman.dnd5esheetmanager.data.local.dao.CharacterDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.CharacterEntity

@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}