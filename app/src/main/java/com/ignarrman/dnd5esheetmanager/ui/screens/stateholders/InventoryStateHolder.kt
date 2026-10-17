package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.ItemRepository
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class InventoryUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val inventory: List<Item> = emptyList(),
)

@ViewModelScoped
class InventoryStateHolder @Inject constructor(
    private val itemRepository: ItemRepository
) {
    private val _state = MutableStateFlow(InventoryUiState())
    val state: StateFlow<InventoryUiState> = _state.asStateFlow()

    private val itemsMap = mutableMapOf<Long, Item>()
}