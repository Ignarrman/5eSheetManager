package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell

data class CharacterSheet(
    val id: Long? = null,
    val portraitUri: String? = null,
    val name: String = "",
    val level: Int = 1,
    val experiencePoints: Int = 0,
    val proficiencyBonus: Int,

    val stats: Map<AbilityScores, Int> = emptyMap(),
    val skills: Map<Skill, Int> = emptyMap(),

    val raceId: Long? = null,
    val backgroundId: Long? = null,
    val playerClassId: Long? = null,

    val featIds: List<Long> = emptyList(),

    val armorClass: Int? = null,

    val maxHp: Int? = null,
    val currentHp: Int? = null,
    val temporaryHp: Int = 0,

    val currentHitDice: Int = 0,

    val skillProficiencies: List<Skill> = emptyList(),
    val skillExpertise: List<Skill> = emptyList(),
    val savingThrowProficiencies: List<AbilityScores> = emptyList(),
    val proficiencies: List<String> = emptyList(),

//    val inventoryIds: List<Long> = emptyList(),
//    val weaponIds: List<Long> = emptyList(),

    val spellIds: List<Long> = emptyList(),

    val notes: String = "",

    val wallet: Map<Coins, Int> = emptyMap()
)

data class ProficiencyBonusProgression(
    val level: Int,
    val bonus: Int
)