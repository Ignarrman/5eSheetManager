package com.ignarrman.dnd5esheetmanager.data.mappers

import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetData
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetPersistence
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSpellCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ItemEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.WeaponEntity
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

fun CharacterSheet.toPersistence(): CharacterSheetPersistence {

    val entity = CharacterSheetEntity(
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
        backgroundId = background?.id,
        playerClassId = null,

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

    val featRelations =
        feats.map { feat ->
            CharacterFeatCrossRef(
                characterId = id ?: 0,
                featId = feat.id!!
            )
        }

    val spellRelations =
        spells.map { spell ->
            CharacterSpellCrossRef(
                characterId = id ?: 0,
                spellId = spell.id!!
            )
        }

    return CharacterSheetPersistence(
        entity = entity,
        featRelations = featRelations,
        spellRelations = spellRelations
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
private fun List<Long>.longToJson(): String {
    return JSONArray(this).toString()
}

fun CharacterSheetData.toDomain(): CharacterSheet {

    return CharacterSheet(
        id = characterSheetEntity.id,
        portraitUri = characterSheetEntity.portraitUri,
        name = characterSheetEntity.name,
        level = characterSheetEntity.level,
        experiencePoints = characterSheetEntity.experiencePoints,
        proficiencyBonus = characterSheetEntity.proficiencyBonus,
        initiative = characterSheetEntity.initiative,

        stats = characterSheetEntity.stats.toAbilityScoresMap(),
        skills = characterSheetEntity.skills.toSkillMap(),

        race = race?.toDomain(),
        background = background?.toDomain(),
        playerClassId = characterSheetEntity.playerClassId,
        feats = feats.map { it.toDomain() },
        spells = spells.map { it.toDomain() },

        armorClass = characterSheetEntity.armorClass,

        maxHp = characterSheetEntity.maxHp,
        currentHp = characterSheetEntity.currentHp,
        temporaryHp = characterSheetEntity.temporaryHp,

        currentHitDice = characterSheetEntity.currentHitDice,

        deathSaveFailures = characterSheetEntity.deathSaveFailures,
        deathSaveSuccesses = characterSheetEntity.deathSaveSuccesses,

        skillProficiencies =
            characterSheetEntity.skillProficiencies.toEnumList(Skill::valueOf),

        skillExpertise =
            characterSheetEntity.skillExpertise.toEnumList(Skill::valueOf),

        savingThrowProficiencies =
            characterSheetEntity.savingThrowProficiencies.toEnumList(AbilityScores::valueOf),

        proficiencies =
            characterSheetEntity.proficiencies.toStringList(),

        notes = characterSheetEntity.notes,

        wallet = characterSheetEntity.wallet.toCoinsMap()
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