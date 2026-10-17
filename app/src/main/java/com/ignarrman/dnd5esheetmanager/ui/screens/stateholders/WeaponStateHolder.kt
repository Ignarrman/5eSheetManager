package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.WeaponRepository
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class WeaponUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val characterWeapons: List<Weapon> = emptyList(),
)

@ViewModelScoped
class WeaponStateHolder @Inject constructor(
    private val weaponRepository: WeaponRepository
) {

    private val _state = MutableStateFlow(WeaponUiState())
    val state: StateFlow<WeaponUiState> = _state.asStateFlow()

    private val weaponsMap = mutableMapOf<Long, Weapon>()
}