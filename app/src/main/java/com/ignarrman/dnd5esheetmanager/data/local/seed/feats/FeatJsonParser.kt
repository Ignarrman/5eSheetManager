package com.ignarrman.dnd5esheetmanager.data.local.seed.feats

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object FeatJsonParser {

    fun parse(
        context: Context,
        fileName: String,
        startingId: Long
    ): List<ParsedFeat> {

        val json = context.assets
            .open("feats/$fileName")
            .bufferedReader()
            .use { it.readText() }

        val root = JSONObject(json)

        val feats = root.optJSONArray("feat")
            ?: return emptyList()

        val result = mutableListOf<ParsedFeat>()

        var nextId = startingId

        for (index in 0 until feats.length()) {

            val featJson = feats.optJSONObject(index)
                ?: continue

            val name = featJson
                .optString("name")
                .trim()

            if (name.isBlank()) {
                continue
            }

            val description = featJson
                .optJSONArray("entries")
                ?.let { flattenEntries(it) }
                ?: ""

            val prerequisite = parsePrerequisite(
                featJson.optJSONArray("prerequisite")
            )

            val abilityBonus = parseAbility(
                featJson.optJSONArray("ability")
            )

            result += ParsedFeat(
                id = nextId,
                name = name,
                description = description,
                prerequisite = prerequisite,
                abilityBonus = abilityBonus
            )

            nextId++
        }

        return result
    }

    private fun parsePrerequisite(
        prerequisite: JSONArray?
    ): String {

        if (prerequisite == null || prerequisite.length() == 0) {
            return ""
        }

        val result = mutableListOf<String>()

        for (index in 0 until prerequisite.length()) {

            val value = prerequisite.optJSONObject(index)
                ?: continue

            val parts = mutableListOf<String>()

            value.opt("level")?.let {
                if (it.toString().isNotBlank()) {
                    parts += "Level ${it}"
                }
            }

            value.optJSONObject("ability")?.let {
                val ability = formatAbilityObject(it)

                if (ability.isNotBlank()) {
                    parts += ability
                }
            }

            value.optString("race")
                .takeIf { it.isNotBlank() }
                ?.let {
                    parts += "Race: $it"
                }

            value.optString("proficiency")
                .takeIf { it.isNotBlank() }
                ?.let {
                    parts += "Proficiency: $it"
                }

            value.optString("spellcasting")
                .takeIf { it.isNotBlank() }
                ?.let {
                    parts += "Spellcasting"
                }

            value.optString("other")
                .takeIf { it.isNotBlank() }
                ?.let {
                    parts += it
                }

            value.optJSONArray("feat")?.let {
                val feats = mutableListOf<String>()

                for (featIndex in 0 until it.length()) {
                    val feat = it.optString(featIndex)

                    if (feat.isNotBlank()) {
                        feats += feat
                    }
                }

                if (feats.isNotEmpty()) {
                    parts += "Feat: ${feats.joinToString(", ")}"
                }
            }

            if (parts.isNotEmpty()) {
                result += parts.joinToString("; ")
            }
        }

        return result.joinToString(" OR ")
    }

    private fun parseAbility(
        ability: JSONArray?
    ): String {

        if (ability == null || ability.length() == 0) {
            return ""
        }

        val result = mutableListOf<String>()

        for (index in 0 until ability.length()) {

            val value = ability.optJSONObject(index)
                ?: continue

            val choose = value.optJSONObject("choose")

            if (choose != null) {

                val amount = choose.optInt("amount", 1)

                val from = choose.optJSONArray("from")

                if (from != null && from.length() > 0) {

                    val abilities = mutableListOf<String>()

                    for (abilityIndex in 0 until from.length()) {
                        abilities += formatAbilityName(
                            from.optString(abilityIndex)
                        )
                    }

                    result += "Choose one: ${abilities.joinToString(", ")} +$amount"
                }

                continue
            }

            val parts = mutableListOf<String>()

            val keys = value.keys()

            while (keys.hasNext()) {

                val key = keys.next()

                val amount = value.optInt(key, 0)

                if (amount != 0) {
                    parts += "${formatAbilityName(key)} ${if (amount > 0) "+$amount" else amount}"
                }
            }

            if (parts.isNotEmpty()) {
                result += parts.joinToString(", ")
            }
        }

        return result.joinToString("; ")
    }

    private fun formatAbilityObject(
        ability: JSONObject
    ): String {

        val result = mutableListOf<String>()

        val keys = ability.keys()

        while (keys.hasNext()) {

            val key = keys.next()

            val value = ability.optInt(key, 0)

            if (value != 0) {
                result += "${formatAbilityName(key)} $value"
            }
        }

        return result.joinToString(", ")
    }

    private fun formatAbilityName(
        value: String
    ): String {

        return when (value.lowercase()) {
            "str" -> "Strength"
            "dex" -> "Dexterity"
            "con" -> "Constitution"
            "int" -> "Intelligence"
            "wis" -> "Wisdom"
            "cha" -> "Charisma"
            else -> value
        }
    }

    private fun flattenEntries(
        entries: JSONArray
    ): String {

        val result = mutableListOf<String>()

        for (index in 0 until entries.length()) {

            val value = entries.opt(index)

            when (value) {

                is String -> {

                    if (value.isNotBlank()) {
                        result += value
                    }
                }

                is JSONObject -> {

                    val parts = mutableListOf<String>()

                    val name = value
                        .optString("name")
                        .trim()

                    if (name.isNotBlank()) {
                        parts += name
                    }

                    value.optString("entry")
                        .takeIf { it.isNotBlank() }
                        ?.let {
                            parts += it
                        }

                    value.optJSONArray("entries")?.let {
                        val nested = flattenEntries(it)

                        if (nested.isNotBlank()) {
                            parts += nested
                        }
                    }

                    value.optJSONArray("items")?.let {
                        val nested = flattenEntries(it)

                        if (nested.isNotBlank()) {
                            parts += nested
                        }
                    }

                    if (value.optString("type") == "table") {

                        val table = flattenTable(value)

                        if (table.isNotBlank()) {
                            parts += table
                        }
                    }

                    if (parts.isNotEmpty()) {
                        result += parts.joinToString("\n")
                    }
                }
            }
        }

        return result.joinToString("\n\n")
    }

    private fun flattenTable(
        table: JSONObject
    ): String {

        val result = mutableListOf<String>()

        val caption = table
            .optString("caption")
            .trim()

        if (caption.isNotBlank()) {
            result += caption
        }

        val rows = table.optJSONArray("rows")

        if (rows != null) {

            for (rowIndex in 0 until rows.length()) {

                val row = rows.optJSONArray(rowIndex)
                    ?: continue

                val cells = mutableListOf<String>()

                for (cellIndex in 0 until row.length()) {
                    cells += row.optString(cellIndex)
                }

                if (cells.isNotEmpty()) {
                    result += cells.joinToString(" | ")
                }
            }
        }

        return result.joinToString("\n")
    }
}