package com.ignarrman.dnd5esheetmanager.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    onCreateCharacter: () -> Unit,
    onLoadCharacter: (Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeContent(
        state = state,
        onCreateCharacter = onCreateCharacter,
        onLoadCharacter = onLoadCharacter
    )

}

@Composable
fun HomeContent(
    state: HomeUiState,
    onCreateCharacter: () -> Unit,
    onLoadCharacter: (Long) -> Unit,
) {

}