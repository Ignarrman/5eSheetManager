package com.ignarrman.dnd5esheetmanager.ui.screens.home

sealed interface HomeIntent {

    data object LoadCharacters: HomeIntent
    data class LoadCharacter(val id: Long): HomeIntent
    data object CreateNewCharacter: HomeIntent
    data class DeleteCharacter(val id: Long): HomeIntent

}