package com.ignarrman.dnd5esheetmanager.data.local.seed.background

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object BackgroundJsonParser {

    fun parse(
        context: Context,
        fileName: String
    ): List<ParsedBackground> {

        val json = context.assets
            .open("backgrounds/$fileName")
            .bufferedReader()
            .use { it.readText() }

        val root = JSONObject(json)

        val backgrounds = root.optJSONArray("background")
            ?: return emptyList()

        val result = mutableListOf<ParsedBackground>()

        for (index in 0 until backgrounds.length()) {

            val backgroundJson =
                backgrounds.optJSONObject(index)
                    ?: continue

            val name = backgroundJson
                .optString("name")
                .trim()

            if (name.isBlank()) {
                continue
            }

            val skillProficiencies =
                parseSkillProficiencies(
                    backgroundJson.optJSONArray("skillProficiencies")
                )

            val languages =
                parseTextValue(
                    backgroundJson.optJSONArray("languages")
                )

            val equipment =
                parseEquipment(
                    backgroundJson.optJSONArray("startingEquipment")
                )

            val feature =
                parseFeature(
                    backgroundJson.optJSONArray("entries")
                )

            result += ParsedBackground(
                id = result.size + 1L,
                name = name,
                skillProficiencies = skillProficiencies,
                languages = languages,
                equipment = equipment,
                featureName = feature.first,
                featureDescription = feature.second
            )
        }

        return result
    }

    private fun parseSkillProficiencies(
        array: JSONArray?
    ): List<String> {

        if (array == null) {
            return emptyList()
        }

        val result = mutableListOf<String>()

        for (index in 0 until array.length()) {

            val value = array.opt(index)

            when (value) {

                is JSONObject -> {
                    for (key in value.keys()) {
                        result += key
                    }
                }

                is String -> {
                    result += value
                }
            }
        }

        return result
    }

    private fun parseTextValue(
        array: JSONArray?
    ): String? {

        if (array == null || array.length() == 0) {
            return null
        }

        return flattenEntries(array)
            .takeIf { it.isNotBlank() }
    }

    private fun parseEquipment(
        array: JSONArray?
    ): String? {

        if (array == null || array.length() == 0) {
            return null
        }

        return flattenEntries(array)
            .takeIf { it.isNotBlank() }
    }

    private fun parseFeature(
        entries: JSONArray?
    ): Pair<String, String> {

        if (entries == null) {
            return "" to ""
        }

        for (index in 0 until entries.length()) {

            val value = entries.optJSONObject(index)
                ?: continue

            val type = value.optString("type")

            if (type == "entries") {

                val name = value
                    .optString("name")
                    .trim()

                val description = value
                    .optJSONArray("entries")
                    ?.let { flattenEntries(it) }
                    ?: ""

                if (name.isNotBlank()) {
                    return name to description
                }
            }
        }

        return "" to flattenEntries(entries)
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

                    val name = value.optString("name")

                    if (name.isNotBlank()) {
                        parts += name
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

        val caption = table.optString("caption")

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