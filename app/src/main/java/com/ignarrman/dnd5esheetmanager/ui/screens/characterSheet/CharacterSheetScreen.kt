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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.FeaturesTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.GeneralTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.InventoryTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.NotesTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.SkillsTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.SpellsTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components.WeaponsTabContent
import com.ignarrman.dnd5esheetmanager.ui.screens.components.AppTopBar
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.BackgroundUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.CharacterSheetUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.ClassUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.InventoryUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.RaceUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.SpellsUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.WeaponUiState
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun CharacterSheetScreen(
    characterId: Long?,
    onBack: () -> Unit,
    viewModel: CharacterSheetViewModel = hiltViewModel()
){

    val characterState by viewModel.characterState.collectAsStateWithLifecycle()
    val spellsState by viewModel.spellsState.collectAsStateWithLifecycle()
    val racesState by viewModel.racesState.collectAsStateWithLifecycle()
    val classesState by viewModel.classesState.collectAsStateWithLifecycle()
    val backgroundsState by viewModel.backgroundsState.collectAsStateWithLifecycle()
    val inventoryState by viewModel.inventoryState.collectAsStateWithLifecycle()
    val weaponsState by viewModel.weaponsState.collectAsStateWithLifecycle()

    CharacterSheetContent(
        characterState = characterState,
        spellsState = spellsState,
        racesState = racesState,
        classesState = classesState,
        backgroundsState = backgroundsState,
        inventoryState = inventoryState,
        weaponsState = weaponsState,
        onBack = onBack
    )

}

@Composable
fun CharacterSheetContent(
    characterState: CharacterSheetUiState,
    spellsState: SpellsUiState,
    racesState: RaceUiState,
    classesState: ClassUiState,
    backgroundsState: BackgroundUiState,
    inventoryState: InventoryUiState,
    weaponsState: WeaponUiState,
    onBack: () -> Unit,
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = CharacterSheetTab.entries

    val characterSheet = characterState.characterSheet
    val characterClass = classesState.classes.firstOrNull { it.id == characterSheet.playerClassId }


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
                                fontSize = 16.sp,
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
                    race = characterSheet.race,
                    background = characterSheet.background,
                    playerClass = characterClass,

                    races = racesState.races,
                    classes = classesState.classes,
                    backgrounds = backgroundsState.backgrounds,

                    onNameChange = {
                        // TODO
                    },
                    onRaceChange = {
                        // TODO
                    },
                    onClassChange = {
                        // TODO
                    },
                    onBackgroundChange = {
                        // TODO
                    },
                )
                CharacterSheetTab.FEATURES -> FeaturesTabContent(
                    classFeatures = characterClass?.features?.filterKeys { it in 1..characterSheet.level } ?: emptyMap(),
                    raceFeatures = characterSheet.race?.features ?: emptyList(),
                    backgroundFeatures = characterSheet.background?.feature,
                    featList = characterSheet.feats
                )
                CharacterSheetTab.WEAPONS -> WeaponsTabContent(
                    weapons = weaponsState.characterWeapons,
                    proficiencyBonus = characterSheet.proficiencyBonus,
                    onAddWeapon = {
                        // TODO
                    },
                    onProficiencyChange = {
                        // TODO
                    }
                )
                CharacterSheetTab.INVENTORY -> InventoryTabContent(
                    inventory = inventoryState.characterInventory,
                    onAddItem = {
                        // TODO
                    }
                )
                CharacterSheetTab.SPELLS -> SpellsTabContent(
                    characterSpells = characterSheet.spells,
                    castingScore = characterClass?.spellcasting?.spellcastingAbility ?: AbilityScores.INT,
                    castingScoreValue = characterSheet.stats[characterClass?.spellcasting?.spellcastingAbility] ?: 0,
                    spellSlots = characterClass?.spellcasting?.spellSlotProgression[characterSheet.level],
                    proficiencyBonus = characterSheet.proficiencyBonus,
                    spentSpellSlots = characterSheet.spellSlotUsed,
                    onSpentSpellSlotsChange = {
                        // TODO
                    },
                    onAddSpell = {
                        // TODO
                    }
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
    val fakeSheetState = CharacterSheetUiState(
        isLoading = isLoading,
        characterSheet = FakeCharacterSheet.shadowmere,
    )
    val fakeClassesState = ClassUiState(
        isLoading = isLoading,
        classes = FakePlayerClass.all,
    )
    val fakeRaceState = RaceUiState(
        isLoading = isLoading,
        races = FakeRace.all
    )
    val fakeBackgroundState = BackgroundUiState(
        isLoading = isLoading,
        backgrounds = FakeBackground.all
    )
    val fakeSpellsState = SpellsUiState(
        isLoading = isLoading,
        spells = FakeSpells.all
    )
    val fakeInventoryState = InventoryUiState(
        isLoading = isLoading,
        characterInventory = FakeItem.all
    )
    val fakeWeaponsState = WeaponUiState(
        isLoading = isLoading,
        characterWeapons = FakeWeapons.all
    )

    _5eSheetManagerTheme(){
        CharacterSheetContent(
            characterState = fakeSheetState,
            spellsState = fakeSpellsState,
            racesState = fakeRaceState,
            classesState = fakeClassesState,
            backgroundsState = fakeBackgroundState,
            inventoryState = fakeInventoryState,
            weaponsState = fakeWeaponsState,
            onBack = {}
        )
    }
}