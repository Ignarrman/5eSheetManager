package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.getFeatures
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeBackground
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeRace
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.CharacterSheetTab
import com.ignarrman.dnd5esheetmanager.ui.screens.components.AppTopBar
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.FeaturesTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.GeneralTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.InventoryTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.NotesTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.SkillsTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.SpellsTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.WeaponsTabContent
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun CharacterSheetScreen(
    characterId: Long?,
    onBack: () -> Unit,
    viewModel: CharacterSheetViewModel = hiltViewModel()
){

    val state by viewModel.state.collectAsStateWithLifecycle()

    CharacterSheetContent(
        state = state,
        onBack = onBack
    )

}

@Composable
fun CharacterSheetContent(
    state: CharacterSheetUiState,
    onBack: () -> Unit,
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = CharacterSheetTab.entries

    val characterSheet = state.characterSheet
    val characterRace = state.races.firstOrNull { it.id == characterSheet.raceId }
    val characterBackground = state.backgrounds.firstOrNull { it.id == characterSheet.backgroundId }
    val characterClass = state.classes.firstOrNull { it.id == characterSheet.playerClassId }
    val characterFeats = state.feats.filter { it.id in characterSheet.featsId }
    val characterSpells = state.sp

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Character Sheet",
                onBack = onBack
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)

            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab (
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(tab.title)
                        }
                    )
                }
            }

            when (tabs[selectedTabIndex]) {
                CharacterSheetTab.GENERAL -> GeneralTabContent(
                    characterSheet = characterSheet,
                    race = characterRace,
                    background = characterBackground,
                    playerClass = characterClass
                )
                CharacterSheetTab.FEATURES -> FeaturesTabContent(
                    classFeatures = state.classFeatures,
                    raceFeatures = load,
                    backgroundFeatures = characterBackground.getFeatures(),
                    featList = characterFeats
                )
                CharacterSheetTab.WEAPONS -> WeaponsTabContent()
                CharacterSheetTab.INVENTORY -> InventoryTabContent()
                CharacterSheetTab.SPELLS -> SpellsTabContent()
                CharacterSheetTab.SKILLS -> SkillsTabContent()
                CharacterSheetTab.NOTES -> NotesTabContent()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CharacterSheetContentPreview(isLoading: Boolean = false) {
    val fakeState = CharacterSheetUiState(
        isLoading = isLoading,
        characterSheet = FakeCharacterSheet.shadowmere,
        races = FakeRace.all,
        backgrounds = FakeBackground.all,
        classes = FakePlayerClass.all
    )
    _5eSheetManagerTheme(){
        CharacterSheetContent(
            state = fakeState,
            onBack = {}
        )
    }
}