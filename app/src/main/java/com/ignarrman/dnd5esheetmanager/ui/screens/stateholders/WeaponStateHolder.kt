package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.WeaponRepository
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
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

    suspend fun loadAllWeapons(characterId: Long) {
       val weapons =  weaponRepository.getByCharacterId(characterId)

        _state.value = _state.value.copy(characterWeapons = weapons)
    }

    suspend fun insertWeapon(characterId: Long, weapon: Weapon) {
        weaponRepository.insert(weapon, characterId)
        loadAllWeapons(characterId)
    }

    suspend fun deleteWeapon(characterId: Long, weaponId: Long) {
        weaponRepository.deleteById(weaponId)
        loadAllWeapons(characterId)
    }

    suspend fun updateWeapon(characterId: Long, weapon: Weapon) {
        weaponRepository.update(characterId, weapon)
    }
}