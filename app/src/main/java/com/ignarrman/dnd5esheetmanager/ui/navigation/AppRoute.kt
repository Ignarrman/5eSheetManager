package com.ignarrman.dnd5esheetmanager.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes:NavKey {
    @Serializable
    data object Home: Routes()

    @Serializable
    data class CharacterSheet(val characterId: Long? ): Routes()

}