package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ItemEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.WeaponEntity
import com.ignarrman.dnd5esheetmanager.data.mappers.toJson
import com.ignarrman.dnd5esheetmanager.domain.model.DamageType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Coins
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.MasteryType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.RangeType
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.WeaponProperty
import org.json.JSONArray
import org.json.JSONObject

fun ItemEntity.toDomain(): Item {
    return Item(
        id = id,
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
        id = id!!,
        characterId = characterId,
        name = name,
        description = description,
        price = price,
        quantity = quantity
    )
}

fun WeaponEntity.toDomain(): Weapon {
    return Weapon(
        id = id,
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
        id = id!!,
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

fun CharacterSheet.toEntity(): CharacterSheetEntity {

    return CharacterSheetEntity(
        id = id?: 0L,
        portraitUri = portraitUri,
        name = name,
        level = level,
        experiencePoints = experiencePoints,
        proficiencyBonus = proficiencyBonus,
        initiative = initiative,

        stats = stats.statsToJson(),
        skills = skills.skillsToJson(),

        raceId = null,
        backgroundId = backgroundId,
        playerClassId = null,
        featsId = featsId.toJson(),
        spellsId = spellsId.toJson(),

        armorClass = armorClass,

        maxHp = maxHp,
        currentHp = currentHp,
        temporaryHp = temporaryHp,

        currentHitDice = currentHitDice,
        deathSaveSuccesses = deathSaveSuccesses,
        deathSaveFailures = deathSaveFailures,

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

        wallet = wallet.walletToJson()
    )
}

private fun Map<AbilityScores, Int>.statsToJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

private fun Map<Skill, Int>.skillsToJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

private fun Map<Coins, Int>.walletToJson(): String {
    val json = JSONObject()

    for ((key, value) in this) {
        json.put(key.name, value)
    }

    return json.toString()
}

private fun List<String>.toJson(): String {
    return JSONArray(this).toString()
}
private fun List<Long>.toJson(): String {
    return JSONArray(this).toString()
}

fun CharacterSheetEntity.toDomain(): CharacterSheet {

    return CharacterSheet(
        id = id,
        portraitUri = portraitUri,
        name = name,
        level = level,
        experiencePoints = experiencePoints,
        proficiencyBonus = proficiencyBonus,
        initiative = initiative,

        stats = stats.toAbilityScoresMap(),
        skills = skills.toSkillMap(),

        raceId = raceId,
        backgroundId = backgroundId,
        playerClassId = playerClassId,
        featsId = featsId.toLongList(),
        spellsId = spellsId.toLongList(),

        armorClass = armorClass,

        maxHp = maxHp,
        currentHp = currentHp,
        temporaryHp = temporaryHp,

        currentHitDice = currentHitDice,

        deathSaveFailures = deathSaveFailures,
        deathSaveSuccesses = deathSaveSuccesses,

        skillProficiencies =
            skillProficiencies.toEnumList(Skill::valueOf),

        skillExpertise =
            skillExpertise.toEnumList(Skill::valueOf),

        savingThrowProficiencies =
            savingThrowProficiencies.toEnumList(AbilityScores::valueOf),

        proficiencies =
            proficiencies.toStringList(),

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

fun String.toLongList(): List<Long> {
    val json = JSONArray(this)

    return List(json.length()) { index ->
        json.getLong(index)
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