package com.ignarrman.dnd5esheetmanager.data.local.entities.characterData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_sheets")
data class CharacterSheetEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val portraitUri: String?,
    val name: String,
    val level: Int,
    val experiencePoints: Int,
    val proficiencyBonus: Int,
    val initiative: Int?,

    val stats: String,
    val skills: String,

    val raceId: Long?,
    val backgroundId: Long?,
    val playerClassId: Long?,
    val featsId: String,
    val spellsId: String,

    val armorClass: Int?,
    val maxHp: Int?,
    val currentHp: Int?,
    val temporaryHp: Int,

    val currentHitDice: Int,

    val deathSaveSuccesses: Int = 0,
    val deathSaveFailures: Int = 0,

    val skillProficiencies: String,
    val skillExpertise: String,
    val savingThrowProficiencies: String,

    val proficiencies: String,

    val notes: String,

    val wallet: String
)