package com.ignarrman.dnd5esheetmanager.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ignarrman.dnd5esheetmanager.data.local.repositories.CharacterSheetRepository
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class HomeUiState(
    val isLoading: Boolean = false,
    val savedCharacters: List<CharacterSheet> = emptyList(),
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        handleIntent(HomeIntent.LoadCharacters)
    }

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadCharacters -> loadCharacters()
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {

            _state.update {
                it.copy(isLoading = true)
            }

            val characters = characterSheetRepository.getAllCharacters()

            _state.update {
                it.copy(
                    isLoading = false,
                    savedCharacters = characters
                )
            }
        }
    }
}