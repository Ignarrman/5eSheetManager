package com.ignarrman.dnd5esheetmanager.data.local.seed.helpers

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object ClassFeatureJsonParser {

    fun parse(
        context: Context,
        fileName: String,
        startingId: Long
    ): List<ParsedFeature> {

        val json = context.assets
            .open("classes/$fileName")
            .bufferedReader()
            .use { it.readText() }

        val root = JSONObject(json)

        val classFeatures = root.optJSONArray("classFeature")
            ?: return emptyList()

        val result = mutableListOf<ParsedFeature>()

        var nextId = startingId

        for (index in 0 until classFeatures.length()) {

            val featureJson =
                classFeatures.optJSONObject(index)
                    ?: continue

            val name = featureJson
                .optString("name")
                .trim()

            if (name.isBlank()) {
                continue
            }

            val level = featureJson.optInt("level", 0)

            val description = featureJson
                .optJSONArray("entries")
                ?.let { flattenEntries(it) }
                ?: ""

            result += ParsedFeature(
                id = nextId,
                name = name,
                description = description,
                level = level
            )

            nextId++
        }

        return result
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