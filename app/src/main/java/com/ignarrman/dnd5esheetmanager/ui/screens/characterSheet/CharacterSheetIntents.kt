package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

sealed interface CharacterSheetIntents {

    data object LoadCharacter: CharacterSheetIntents
    data object LoadRace: CharacterSheetIntents
    data object LoadRaces: CharacterSheetIntents
    data object LoadBackground: CharacterSheetIntents
    data object LoadBackgrounds: CharacterSheetIntents
    data object LoadClass: CharacterSheetIntents
    data object LoadClasses: CharacterSheetIntents
    data object LoadFeat: CharacterSheetIntents
    data object LoadFeats: CharacterSheetIntents
    data object LoadSpell: CharacterSheetIntents
    data object LoadSpells: CharacterSheetIntents
    data object LoadItem: CharacterSheetIntents
    data object LoadItems: CharacterSheetIntents
    data object LoadWeapon: CharacterSheetIntents
    data object LoadWeapons: CharacterSheetIntents

//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents
//    data object SaveCharacter: CharacterSheetIntents



}