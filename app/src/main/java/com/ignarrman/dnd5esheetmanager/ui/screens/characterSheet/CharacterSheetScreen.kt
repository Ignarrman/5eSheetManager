package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.getFeatures
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeBackground
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeats
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeatures
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeItem
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeRace
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeSpells
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeWeapons
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
    val characterSpells = state.spells.filter { it.id in characterSheet.spellsId }


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
                modifier = Modifier.fillMaxWidth(),
                edgePadding = 8.dp,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = Color(0xFFF1F4F7),
                indicator = { tabPositions ->
                    if (selectedTabIndex < tabPositions.size) {
                        val selectedTab = tabPositions[selectedTabIndex]

                        TabRowDefaults.SecondaryIndicator(
                            modifier = Modifier
                                .tabIndicatorOffset(selectedTab)
                                .padding(horizontal = 8.dp),
                            height = 3.dp,
                            color = Color(0xFFF1F4F7)
                        )
                    }
                },
                divider = {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            ) {
                tabs.forEachIndexed { index, tab ->
                    val selected = selectedTabIndex == index

                    Tab(
                        selected = selected,
                        onClick = {
                            selectedTabIndex = index
                        },
                        modifier = Modifier.padding(horizontal = 2.dp),
                        selectedContentColor = Color(0xFFF1F4F7),
                        unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        text = {
                            Text(
                                text = tab.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = if (selected) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Medium
                                },
                                maxLines = 1
                            )
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
                    raceFeatures = state.raceFeatures,
                    backgroundFeatures = state.backgroundFeature,
                    featList = characterFeats
                )
                CharacterSheetTab.WEAPONS -> WeaponsTabContent(
                    weapons = state.weapons,
                    proficiencyBonus = characterSheet.proficiencyBonus
                )
                CharacterSheetTab.INVENTORY -> InventoryTabContent(
                    inventory = state.inventory
                )
                CharacterSheetTab.SPELLS -> SpellsTabContent(
                    characterSpells = characterSpells,
                    castingScore = characterClass?.spellcasting?.spellcastingAbility ?: AbilityScores.INT,
                    castingScoreValue = characterSheet.stats[characterClass?.spellcasting?.spellcastingAbility] ?: 0,
                    spellSlots = characterClass?.spellcasting?.spellSlotProgression[characterSheet.level],
                    proficiencyBonus = characterSheet.proficiencyBonus
                )
                CharacterSheetTab.SKILLS -> SkillsTabContent(
                    stats = characterSheet.stats,
                    skillProficiencies = characterSheet.skillProficiencies,
                    skillExpertise = characterSheet.skillExpertise,
                    proficiencyBonus = characterSheet.proficiencyBonus
                )
                CharacterSheetTab.NOTES -> NotesTabContent(
                    notes = characterSheet.notes,
                    onNotesChange = {}
                )
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
        classes = FakePlayerClass.all,

        classFeatures = FakeFeatures.allClass,
        raceFeatures = FakeFeatures.allRace,
        backgroundFeature = FakeFeatures.rusticHospitality,
        feats = FakeFeats.all,
        weapons = FakeWeapons.all,
        inventory = FakeItem.all,
        spells = FakeSpells.all
    )
    _5eSheetManagerTheme(){
        CharacterSheetContent(
            state = fakeState,
            onBack = {}
        )
    }
}