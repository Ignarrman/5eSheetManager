package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

open class PlayerClass(
    open val name: String,
    open val hitDice: Int,
    open val features: List<Feature>
)

data class Artificier(
    override val name: String = "Artificier",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Barbarian(
    override val name: String = "Barbarian",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Bard(
    override val name: String = "Bard",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Cleric(
    override val name: String = "Cleric",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Druid(
    override val name: String = "Druid",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Fighter(
    override val name: String = "Fighter",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Monk(
    override val name: String = "Monk",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Paladin(
    override val name: String = "Paladin",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Ranger(
    override val name: String = "Ranger",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Rogue(
    override val name: String = "Rogue",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Sorcerer(
    override val name: String = "Sorcerer",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Warlock(
    override val name: String = "Warlock",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)

data class Wizard(
    override val name: String = "Wizard",
    override val hitDice: Int = 8,
    override val features: List<Feature>
): PlayerClass(name,hitDice,features)
