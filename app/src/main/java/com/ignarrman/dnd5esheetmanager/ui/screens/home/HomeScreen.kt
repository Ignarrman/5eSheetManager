package com.ignarrman.dnd5esheetmanager.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ignarrman.dnd5esheetmanager.R
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.CharacterSheetIntents
import com.ignarrman.dnd5esheetmanager.ui.screens.home.components.CharacterDialog
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.CharacterSheetUiState
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun HomeScreen(
    onLoadCharacter: (Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val characterState by viewModel.characterState.collectAsStateWithLifecycle()

    HomeContent(
        state = characterState,
        loadCharacters = { viewModel.handleIntent(HomeIntent.LoadCharacters) },
        createCharacter = { viewModel.handleIntent(HomeIntent.CreateNewCharacter) },
        onLoadCharacter = onLoadCharacter,
        onLoadCharacterClicked = { id -> viewModel.handleIntent(HomeIntent.LoadCharacter(id)) },
        onDelete = { characterId ->
            viewModel.handleIntent(HomeIntent.DeleteCharacter(characterId))
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    state: CharacterSheetUiState,
    loadCharacters: () -> Unit,
    createCharacter: () -> Unit,
    onLoadCharacter: (Long) -> Unit,
    onLoadCharacterClicked: (Long) -> Unit,
    onDelete: (Long) -> Unit
) {

    val showDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        loadCharacters()
    }

    LaunchedEffect(state.characterSheet) {
        if (state.characterSheet != CharacterSheet.Empty) {
            onLoadCharacter(state.characterSheet.id!!)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(150.dp))

        Image(
            modifier = Modifier,
            painter = painterResource(R.drawable.dnd_banner),
            contentDescription = null,
        )

        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(size = 8.dp),
            enabled = !state.isLoading,
            onClick = {
                createCharacter()
            }
        ) {
            Text("Create Character")
        }

        Spacer(Modifier.size(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(size = 8.dp),
            enabled = !state.isLoading,
            onClick = { showDialog.value = true }
        ) {
            Text("Load Character")
        }
    }

    if (showDialog.value) {
        CharacterDialog(
            savedCharacters = state.characters,
            onDismiss = { showDialog.value = false },
            onLoadClick = onLoadCharacterClicked,
            onDelete = onDelete
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview(isLoading: Boolean = false) {
    val fakeState = CharacterSheetUiState(
        isLoading = isLoading,
        characters = FakeCharacterSheet.all
    )
    _5eSheetManagerTheme(){
        HomeContent(
            state = fakeState,
            loadCharacters = {},
            createCharacter = {},
            onLoadCharacter = {},
            onLoadCharacterClicked = {},
            onDelete = {}
        )
    }
}