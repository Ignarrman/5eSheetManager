package com.ignarrman.dnd5esheetmanager.data.local.seed.spells

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import org.json.JSONArray
import org.json.JSONObject
import java.util.Locale

object SpellJsonParser {

    fun parseAll(context: Context): List<SpellEntity> {
        val assetManager = context.assets

        val files = assetManager
            .list("spells")
            .orEmpty()
            .filter { fileName ->
                fileName.startsWith("spells-") &&
                        fileName.endsWith(".json")
            }
            .sortedWith(
                compareBy(
                    { if (it == "spells-phb.json") 0 else 1 },
                    { it }
                )
            )

        val spellsByName = LinkedHashMap<String, SpellEntity>()
        var nextId = 1L

        for (fileName in files) {
            val json = assetManager
                .open("spells/$fileName")
                .bufferedReader()
                .use { it.readText() }

            val root = JSONObject(json)
            val spells = root.optJSONArray("spell") ?: continue

            for (index in 0 until spells.length()) {
                val spellJson = spells.optJSONObject(index) ?: continue
                val spell = parseSpell(spellJson) ?: continue

                /*
                 * SpellEntity se identifica por ID.
                 *
                 * Si un hechizo aparece en varios libros, conservamos
                 * la primera aparición.
                 *
                 * PHB tiene prioridad porque spells-phb.json se procesa
                 * antes que el resto.
                 */
                if (spell.name !in spellsByName) {
                    spellsByName[spell.name] = spell.copy(id = nextId)
                    nextId++
                }
            }
        }

        return spellsByName.values.toList()
    }

    private fun parseSpell(json: JSONObject): SpellEntity? {
        val name = json.optString("name").trim()

        if (name.isBlank()) {
            return null
        }

        val components = parseComponents(
            json.optJSONObject("components")
        )

        return SpellEntity(
            name = name,
            source = json.getString("source"),
            level = json.optInt("level", 0),
            school = parseSchool(
                json.optString("school")
            ),
            castingTime = parseCastingTime(
                json.optJSONArray("time")
            ),
            range = parseRange(
                json.optJSONObject("range")
            ),
            verbal = components.verbal,
            somatic = components.somatic,
            material = components.material,
            duration = parseDuration(
                json.optJSONArray("duration")
            ),
            concentration = parseConcentration(
                json.optJSONArray("duration")
            ),
            ritual = json
                .optJSONObject("meta")
                ?.optBoolean("ritual", false)
                ?: false,
            description = parseDescription(json)
        )
    }

    private data class ParsedComponents(
        val verbal: Boolean,
        val somatic: Boolean,
        val material: String?
    )

    private fun parseComponents(json: JSONObject?): ParsedComponents {
        if (json == null) {
            return ParsedComponents(
                verbal = false,
                somatic = false,
                material = null
            )
        }

        val material = when (val value = json.opt("m")) {
            is String -> value

            is JSONObject -> {
                value.optString(
                    "text",
                    value.toString()
                )
            }

            else -> null
        }

        return ParsedComponents(
            verbal = json.optBoolean("v", false),
            somatic = json.optBoolean("s", false),
            material = material
        )
    }

    private fun parseSchool(value: String): String {
        return when (value.uppercase(Locale.ROOT)) {
            "A" -> "ABJURATION"
            "C" -> "CONJURATION"
            "D" -> "DIVINATION"
            "E" -> "ENCHANTMENT"
            "V" -> "EVOCATION"
            "I" -> "ILLUSION"
            "N" -> "NECROMANCY"
            "T" -> "TRANSMUTATION"
            else -> value
        }
    }

    private fun parseCastingTime(time: JSONArray?): String {
        if (time == null || time.length() == 0) {
            return ""
        }

        return buildString {
            for (index in 0 until time.length()) {
                if (index > 0) {
                    append(" or ")
                }

                val entry = time.optJSONObject(index)

                if (entry == null) {
                    append(time.optString(index))
                    continue
                }

                val number = entry.optInt("number", 1)
                val unit = entry.optString("unit")

                append(number)
                append(" ")
                append(formatUnit(unit))

                val condition = entry.optString("condition")

                if (condition.isNotBlank()) {
                    append(" ")
                    append(condition)
                }
            }
        }
    }

    private fun parseRange(range: JSONObject?): String {
        if (range == null) {
            return ""
        }

        val type = range.optString("type")

        if (type == "special") {
            return "Special"
        }

        val distance = range.optJSONObject("distance")

        if (distance == null) {
            return ""
        }

        val amount = distance.opt("amount")
        val distanceType = distance.optString("type")

        return when (distanceType) {
            "feet" -> "$amount feet"
            "miles" -> "$amount miles"
            "self" -> "Self"
            "touch" -> "Touch"
            "sight" -> "Sight"
            "unlimited" -> "Unlimited"

            else -> {
                if (amount != null) {
                    "$amount $distanceType"
                } else {
                    distanceType
                }
            }
        }
    }

    private fun parseDuration(duration: JSONArray?): String {
        if (duration == null || duration.length() == 0) {
            return ""
        }

        return buildString {
            for (index in 0 until duration.length()) {
                if (index > 0) {
                    append(" or ")
                }

                val entry = duration.optJSONObject(index)

                if (entry == null) {
                    append(duration.optString(index))
                    continue
                }

                append(formatDurationEntry(entry))
            }
        }
    }

    private fun formatDurationEntry(entry: JSONObject): String {
        return when (entry.optString("type")) {
            "instant" -> "Instantaneous"

            "special" -> "Special"

            "permanent" -> {
                val ends = entry.optJSONArray("ends")

                if (ends == null || ends.length() == 0) {
                    "Permanent"
                } else {
                    buildString {
                        append("Permanent")

                        val conditions = mutableListOf<String>()

                        for (index in 0 until ends.length()) {
                            val end = ends.optJSONObject(index)

                            if (end != null) {
                                val type = end.optString("type")

                                if (type.isNotBlank()) {
                                    conditions += type
                                }
                            }
                        }

                        if (conditions.isNotEmpty()) {
                            append(" until ")
                            append(conditions.joinToString(", "))
                        }
                    }
                }
            }

            "timed" -> {
                val duration = entry.optJSONObject("duration")

                if (duration == null) {
                    "Timed"
                } else {
                    val amount = duration.opt("amount")
                    val type = duration.optString("type")

                    "$amount ${formatUnit(type)}"
                }
            }

            else -> entry.optString("type")
        }
    }

    private fun parseConcentration(duration: JSONArray?): Boolean {
        if (duration == null) {
            return false
        }

        for (index in 0 until duration.length()) {
            val entry = duration.optJSONObject(index)

            if (entry?.optBoolean("concentration", false) == true) {
                return true
            }
        }

        return false
    }

    private fun parseDescription(json: JSONObject): String {
        val sections = mutableListOf<String>()

        json.optJSONArray("entries")?.let {
            val text = flattenEntries(it)

            if (text.isNotBlank()) {
                sections += text
            }
        }

        /*
         * 5etools guarda "At Higher Levels" fuera de entries
         * en muchos hechizos.
         *
         * Lo incorporamos a la descripción porque forma parte
         * de la información descriptiva del hechizo.
         */
        json.optJSONArray("entriesHigherLevel")?.let {
            val text = flattenEntries(
                entries = it,
                includeObjectNames = true
            )

            if (text.isNotBlank()) {
                sections += text
            }
        }

        return sections.joinToString("\n\n")
    }

    private fun flattenEntries(
        entries: JSONArray,
        includeObjectNames: Boolean = true
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
                    val objectParts = mutableListOf<String>()

                    if (includeObjectNames) {
                        val name = value.optString("name")

                        if (name.isNotBlank()) {
                            objectParts += name
                        }
                    }

                    value.optJSONArray("entries")?.let {
                        val nested = flattenEntries(
                            entries = it,
                            includeObjectNames = true
                        )

                        if (nested.isNotBlank()) {
                            objectParts += nested
                        }
                    }

                    value.optJSONArray("items")?.let {
                        val nested = flattenEntries(
                            entries = it,
                            includeObjectNames = true
                        )

                        if (nested.isNotBlank()) {
                            objectParts += nested
                        }
                    }

                    /*
                     * Conservamos también el contenido de tablas.
                     * No interpretamos los tags de 5etools.
                     */
                    if (value.optString("type") == "table") {
                        val tableText = flattenTable(value)

                        if (tableText.isNotBlank()) {
                            objectParts += tableText
                        }
                    }

                    if (objectParts.isNotEmpty()) {
                        result += objectParts.joinToString("\n")
                    }
                }
            }
        }

        return result.joinToString("\n\n")
    }

    private fun flattenTable(table: JSONObject): String {
        val parts = mutableListOf<String>()

        val caption = table.optString("caption")

        if (caption.isNotBlank()) {
            parts += caption
        }

        val labels = table.optJSONArray("colLabels")
        val rows = table.optJSONArray("rows")

        if (rows != null) {
            for (rowIndex in 0 until rows.length()) {
                val row = rows.optJSONArray(rowIndex) ?: continue

                val cells = mutableListOf<String>()

                for (cellIndex in 0 until row.length()) {
                    cells += row.optString(cellIndex)
                }

                if (cells.isNotEmpty()) {
                    parts += cells.joinToString(" | ")
                }
            }
        } else if (labels != null) {
            val cells = mutableListOf<String>()

            for (index in 0 until labels.length()) {
                cells += labels.optString(index)
            }

            if (cells.isNotEmpty()) {
                parts += cells.joinToString(" | ")
            }
        }

        return parts.joinToString("\n")
    }

    private fun formatUnit(unit: String): String {
        return when (unit.lowercase(Locale.ROOT)) {
            "action" -> "action"
            "bonus action" -> "bonus action"
            "reaction" -> "reaction"
            "round" -> "round"
            "minute" -> "minute"
            "hour" -> "hour"
            "day" -> "day"
            "week" -> "week"
            else -> unit
        }
    }
}