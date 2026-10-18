package com.ignarrman.dnd5esheetmanager.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ignarrman.dnd5esheetmanager.data.local.repositories.CharacterSheetRepository
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.CharacterSheetStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterSheetStateHolder: CharacterSheetStateHolder,
) : ViewModel() {

    val characterState = characterSheetStateHolder.state

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
             is HomeIntent.LoadCharacters -> {
                viewModelScope.launch {
                    characterSheetStateHolder.loadAllCharacters()
                }
            }
            is HomeIntent.LoadCharacter -> {
                viewModelScope.launch {
                    characterSheetStateHolder.loadCharacter(intent.id)
                }
            }
            is HomeIntent.CreateNewCharacter -> {
                viewModelScope.launch {
                    characterSheetStateHolder.insertCharacter(CharacterSheet.Empty)
                }
            }

            is HomeIntent.DeleteCharacter -> {
                viewModelScope.launch {
                    characterSheetStateHolder.deleteCharacter(intent.id)
                }
            }

        }
    }
}