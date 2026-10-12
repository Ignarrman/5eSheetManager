package com.ignarrman.dnd5esheetmanager.ui.screens.home

sealed interface HomeIntent {

    data object LoadCharacters: HomeIntent

}