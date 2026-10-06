package com.ignarrman.dnd5esheetmanager.data.local.seed.races

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object RaceJsonParser {

    fun parse(
        context: Context,
        fileName: String,
        startingId: Long
    ): List<ParsedRace> {

        val json = context.assets
            .open("races/$fileName")
            .bufferedReader()
            .use { it.readText() }

        val root = JSONObject(json)

        val races = root.optJSONArray("race")
            ?: return emptyList()

        val result = mutableListOf<ParsedRace>()

        var nextId = startingId

        for (index in 0 until races.length()) {

            val raceJson = races.optJSONObject(index)
                ?: continue

            val name = raceJson
                .optString("name")
                .trim()

            if (name.isBlank()) {
                continue
            }

            val source = raceJson
                .optString("source")
                .trim()

            val size = parseSize(
                raceJson.optJSONArray("size")
            )

            val speed = parseSpeed(
                raceJson.opt("speed")
            )

            val features = parseFeatures(
                raceJson.optJSONArray("entries")
            )

            result += ParsedRace(
                id = nextId,
                name = name,
                source = source,
                size = size,
                landSpeed = speed.land,
                swimSpeed = speed.swim,
                climbSpeed = speed.climb,
                flySpeed = speed.fly,
                features = features
            )

            nextId++
        }

        return result
    }

    private fun parseSize(
        sizes: JSONArray?
    ): String {

        if (sizes == null || sizes.length() == 0) {
            return "MEDIUM"
        }

        return when (sizes.optString(0)) {
            "S" -> "SMALL"
            "M" -> "MEDIUM"
            "L" -> "LARGE"
            else -> "MEDIUM"
        }
    }

    private fun parseSpeed(
        value: Any?
    ): ParsedSpeed {

        if (value is Number) {
            return ParsedSpeed(
                land = value.toInt(),
                swim = null,
                climb = null,
                fly = null
            )
        }

        if (value is JSONObject) {
            return ParsedSpeed(
                land = parseSpeedValue(value.opt("walk")) ?: 0,
                swim = parseSpeedValue(value.opt("swim")),
                climb = parseSpeedValue(value.opt("climb")),
                fly = parseSpeedValue(value.opt("fly"))
            )
        }

        return ParsedSpeed(
            land = 0,
            swim = null,
            climb = null,
            fly = null
        )
    }

    private fun parseSpeedValue(
        value: Any?
    ): Int? {

        return when (value) {
            is Number -> value.toInt()

            is String -> value
                .removeSuffix(" ft.")
                .removeSuffix(" ft")
                .trim()
                .toIntOrNull()

            else -> null
        }
    }

    private fun parseFeatures(
        entries: JSONArray?
    ): List<ParsedRaceFeature> {

        if (entries == null) {
            return emptyList()
        }

        val result = mutableListOf<ParsedRaceFeature>()

        for (index in 0 until entries.length()) {

            val entry = entries.optJSONObject(index)
                ?: continue

            val name = entry
                .optString("name")
                .trim()

            if (name.isBlank()) {
                continue
            }

            val description = entry
                .optJSONArray("entries")
                ?.let { flattenEntries(it) }
                ?: ""

            result += ParsedRaceFeature(
                name = name,
                description = description
            )
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

                    val name = value
                        .optString("name")
                        .trim()

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

                    if (value.optString("type") == "item") {
                        val entryText = value
                            .optString("entry")
                            .trim()

                        if (entryText.isNotBlank()) {
                            parts += entryText
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

    private data class ParsedSpeed(
        val land: Int,
        val swim: Int?,
        val climb: Int?,
        val fly: Int?
    )
}