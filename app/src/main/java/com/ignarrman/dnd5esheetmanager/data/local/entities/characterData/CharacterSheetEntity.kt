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

    val stats: String,
    val skills: String,

    val raceId: Long?,
    val backgroundName: String?,
    val playerClassId: Long?,

    val armorClass: Int?,
    val maxHp: Int?,
    val currentHp: Int?,
    val temporaryHp: Int,

    val currentHitDice: Int,

    val skillProficiencies: String,
    val skillExpertise: String,
    val savingThrowProficiencies: String,

    val proficiencies: String,

    val notes: String,

    val wallet: String
)

@Entity(
    tableName = "character_feats",
    primaryKeys = ["characterId", "featId"]
)
data class CharacterFeatCrossRef(
    val characterId: Long,
    val featId: Long
)


@Entity(
    tableName = "character_spells",
    primaryKeys = ["characterId", "spellName"]
)
data class CharacterSpellCrossRef(
    val characterId: Long,
    val spellName: String
)