package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

import android.graphics.Bitmap
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell

data class CharacterSheet(
    val portrait: Bitmap,
    val name: String?,
    val level: Int = 1,
    val experiencePoints: Int,
    val stats: Map<AbilityScores, Int> = emptyMap(),
    val skills: Map<Skill, Int> = emptyMap(),
    val race: Race?,
    val background: Background?,
    val proficiencyBonus: Map<Int, ProficiencyBonusProgression>,
    val playerClass: PlayerClass?,
    val feats: List<Feat> = emptyList(),
    val armorClass: Int?,
    val hp: Int?,
    val currentHp: Int?,
    val tempHP: Int = 0,
    val currentThp: Int = 0,
    val hitDices: Int = level,
    val currentHitDices: Int,
    val initiative: Int,
    val passivePerception: Int,
    val skillProficiencies: List<Skill> = emptyList(),
    val skillExpertise: List<Skill> = emptyList(),
    val savingThrowProficiencies: List<AbilityScores>,
    val inventory: List<Item> = emptyList(),
    val proficiencies: List<String> = emptyList(),
    val notes: String = "",
    val weapons: List<Weapon> = emptyList(),
    val spells: List<Spell> = emptyList(),
    val wallet: Map<Coins, Int>
)

data class ProficiencyBonusProgression(
    val bonus: Int
)