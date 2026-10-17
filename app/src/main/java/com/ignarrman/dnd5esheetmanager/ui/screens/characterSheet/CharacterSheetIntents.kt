package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

sealed interface CharacterSheetIntents {

    data object LoadCharacter: CharacterSheetIntents
    data object LoadAllCharacters: CharacterSheetIntents
    data object SaveCharacter: CharacterSheetIntents
    data object UpdateCharacter: CharacterSheetIntents
    data object DeleteCharacter: CharacterSheetIntents

    data object LoadRaces: CharacterSheetIntents
    data object LoadBackgrounds: CharacterSheetIntents
    data object LoadClasses: CharacterSheetIntents
    data object LoadFeats: CharacterSheetIntents
    data object LoadSpells: CharacterSheetIntents
    data object LoadItems: CharacterSheetIntents
    data object LoadWeapons: CharacterSheetIntents
}