package com.ignarrman.dnd5esheetmanager.domain.model.spells

data class Spell(
    val id: Long? = null,
    val name: String,
    val level: Int,
    val school: SpellSchool,
    val castingTime: String,
    val range: String,
    val components: SpellComponents,
    val duration: String,
    val description: String,
    val ritual: Boolean,
    val concentration: Boolean,
    val source: String
)

enum class SpellSchool {
    ABJURATION,
    CONJURATION,
    DIVINATION,
    ENCHANTMENT,
    EVOCATION,
    ILLUSION,
    NECROMANCY,
    TRANSMUTATION
}

data class SpellComponents(
    val verbal: Boolean,
    val somatic: Boolean,
    val material: String?
)