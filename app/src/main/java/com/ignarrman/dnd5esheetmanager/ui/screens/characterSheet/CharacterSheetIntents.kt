package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

sealed interface CharacterSheetIntents {

    data class LoadCharacter(val id: Long): CharacterSheetIntents
    data object LoadAllCharacters: CharacterSheetIntents
    data class SaveCharacter(val id: Long): CharacterSheetIntents
    data class UpdateCharacter(val id: Long): CharacterSheetIntents
    data class DeleteCharacter(val id: Long): CharacterSheetIntents

    data object LoadRaces: CharacterSheetIntents
    data object LoadBackgrounds: CharacterSheetIntents
    data object LoadClasses: CharacterSheetIntents
    data object LoadFeats: CharacterSheetIntents
    data object LoadSpells: CharacterSheetIntents
    data object LoadItems: CharacterSheetIntents
    data object LoadWeapons: CharacterSheetIntents
}