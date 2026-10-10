package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ItemEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ProficiencyBonusProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.WeaponEntity
import com.ignarrman.dnd5esheetmanager.domain.model.DamageType
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Coins
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.MasteryType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.ProficiencyBonusProgression
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.RangeType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.WeaponProperty
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import org.json.JSONArray
import org.json.JSONObject

fun ProficiencyBonusProgressionEntity.toDomain(): ProficiencyBonusProgression {
    return ProficiencyBonusProgression(
        level = level,
        bonus = bonus
    )
}

fun ProficiencyBonusProgression.toEntity(): ProficiencyBonusProgressionEntity {
    return ProficiencyBonusProgressionEntity(
        level = level,
        bonus = bonus
    )
}

fun ItemEntity.toDomain(): Item {
    return Item(
        name = name,
        description = description,
        price = price,
        quantity = quantity
    )
}

fun Item.toEntity(
    characterId: Long
): ItemEntity {
    return ItemEntity(
        characterId = characterId,
        name = name,
        description = description,
        price = price,
        quantity = quantity
    )
}

fun WeaponEntity.toDomain(): Weapon {
    return Weapon(
        name = name,
        description = description,
        price = price,
        quantity = quantity,
        damage = damage,
        rangeType = RangeType.valueOf(rangeType),
        masteryType = MasteryType.valueOf(masteryType),
        damageType = DamageType.valueOf(damageType),
        normalRange = normalRange,
        longRange = longRange,
        proficient = proficient,
        attackBonus = attackBonus,
        damageBonus = damageBonus,
        properties = JSONArray(properties).let { json ->
            List(json.length()) { index ->
                WeaponProperty.valueOf(json.getString(index))
            }
        }
    )
}

fun Weapon.toEntity(
    characterId: Long
): WeaponEntity {
    return WeaponEntity(
        characterId = characterId,
        name = name,
        description = description,
        price = price,
        quantity = quantity,
        damage = damage,
        rangeType = rangeType.name,
        masteryType = masteryType.name,
        damageType = damageType.name,
        normalRange = normalRange,
        longRange = longRange,
        proficient = proficient,
        attackBonus = attackBonus,
        damageBonus = damageBonus,
        properties = JSONArray(
            properties.map { it.name }
        ).toString()
    )
}

fun CharacterSheet.toEntity(
    id: Long = 0
): CharacterSheetEntity {

    return CharacterSheetEntity(
        id = id,
        portraitUri = portraitUri,
        name = name,
        level = level,
        experiencePoints = experiencePoints,
        proficiencyBonus = proficiencyBonus,

        stats = stats.toJson(),
        skills = skills.toJson(),

        raceId = null,
        backgroundName = background?.name,
        playerClassId = null,

        armorClass = armorClass,

        maxHp = maxHp,
        currentHp = currentHp,
        temporaryHp = temporaryHp,

        currentHitDice = currentHitDice,

        skillProficiencies =
            skillProficiencies
                .map { it.name }
                .toJson(),

        skillExpertise =
            skillExpertise
                .map { it.name }
                .toJson(),

        savingThrowProficiencies =
            savingThrowProficiencies
                .map { it.name }
                .toJson(),

        proficiencies =
            proficiencies.toJson(),

        notes = notes,

        wallet = wallet.toJson()
    )
}

private fun Map<AbilityScores, Int>.toJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

private fun Map<Skill, Int>.toJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

private fun List<String>.toJson(): String {
    return JSONArray(this).toString()
}

private fun Map<Coins, Int>.toJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

fun CharacterSheetEntity.toDomain(): CharacterSheet {

    return CharacterSheet(
        portraitUri = portraitUri,
        name = name,
        level = level,
        experiencePoints = experiencePoints,
        proficiencyBonus = proficiencyBonus,

        stats = stats.toAbilityScoresMap(),
        skills = skills.toSkillMap(),

        race = race,
        background = background,
        playerClass = playerClass,

        feats = feats,

        armorClass = armorClass,

        maxHp = maxHp,
        currentHp = currentHp,
        temporaryHp = temporaryHp,

        currentHitDice = currentHitDice,

        skillProficiencies =
            skillProficiencies.toEnumList(Skill::valueOf),

        skillExpertise =
            skillExpertise.toEnumList(Skill::valueOf),

        savingThrowProficiencies =
            savingThrowProficiencies.toEnumList(AbilityScores::valueOf),

        inventory = items,

        proficiencies =
            proficiencies.toStringList(),

        weapons = weapons,

        spells = spells,

        notes = notes,

        wallet = wallet.toCoinsMap()
    )
}

private fun String.toAbilityScoresMap(): Map<AbilityScores, Int> {

    val json = JSONObject(this)
    val result = mutableMapOf<AbilityScores, Int>()

    for (key in json.keys()) {
        result[AbilityScores.valueOf(key)] = json.getInt(key)
    }

    return result
}

private fun String.toSkillMap(): Map<Skill, Int> {

    val json = JSONObject(this)
    val result = mutableMapOf<Skill, Int>()

    for (key in json.keys()) {
        result[Skill.valueOf(key)] = json.getInt(key)
    }

    return result
}

private fun <T> String.toEnumList(
    mapper: (String) -> T
): List<T> {

    val json = JSONArray(this)

    return List(json.length()) { index ->
        mapper(json.getString(index))
    }
}

private fun String.toStringList(): List<String> {

    val json = JSONArray(this)

    return List(json.length()) { index ->
        json.getString(index)
    }
}

private fun String.toCoinsMap(): Map<Coins, Int> {

    val json = JSONObject(this)
    val result = mutableMapOf<Coins, Int>()

    for (key in json.keys()) {
        result[Coins.valueOf(key)] = json.getInt(key)
    }

    return result
}