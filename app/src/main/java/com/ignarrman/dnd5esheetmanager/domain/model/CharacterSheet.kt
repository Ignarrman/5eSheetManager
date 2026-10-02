package com.ignarrman.dnd5esheetmanager.domain.model

data class CharacterSheet(
    val name: String,
    val skillPF: List<Skill>,
    val savingThrowPF: List<Skill>,

)
