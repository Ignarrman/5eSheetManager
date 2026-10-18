package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
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
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeBackground
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeats
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeItem
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeRace
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeSpells
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeWeapons
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
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
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.FeatUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.InventoryUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.RaceUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.SpellsUiState
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.WeaponUiState
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun CharacterSheetScreen(
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
    val featState by viewModel.featState.collectAsStateWithLifecycle()

    CharacterSheetContent(
        characterState = characterState,
        spellsState = spellsState,
        racesState = racesState,
        classesState = classesState,
        backgroundsState = backgroundsState,
        inventoryState = inventoryState,
        weaponsState = weaponsState,
        featState = featState,
        onBack = onBack,

        onLoadCharacter = { characterId -> viewModel.handleIntent(CharacterSheetIntents.LoadCharacter(characterId)) },
        onUpdateCharacter = { characterSheet -> viewModel.handleIntent(CharacterSheetIntents.UpdateCharacter(characterSheet)) },

        onLoadRaces = {  viewModel.handleIntent(CharacterSheetIntents.LoadRaces) },
        onLoadClasses = { viewModel.handleIntent(CharacterSheetIntents.LoadClasses) } ,
        onLoadBackgrounds = { viewModel.handleIntent(CharacterSheetIntents.LoadBackgrounds) },

        onLoadSpells = { viewModel.handleIntent(CharacterSheetIntents.LoadSpells) },
        onAddSpell = { characterId, spell -> viewModel.handleIntent(CharacterSheetIntents.AddSpell(characterId, spell)) },
        onRemoveSpell = { characterId, spellId -> viewModel.handleIntent(CharacterSheetIntents.RemoveSpell(characterId, spellId)) },

        onLoadItems = { characterId -> viewModel.handleIntent(CharacterSheetIntents.LoadItems(characterId)) },
        onCreateItem = { characterId, item -> viewModel.handleIntent(CharacterSheetIntents.AddItem(characterId, item)) },
        onRemoveItem = { characterId, itemId -> viewModel.handleIntent(CharacterSheetIntents.RemoveItem(characterId, itemId)) },

        onLoadFeats = {viewModel.handleIntent(CharacterSheetIntents.LoadFeats)},
        onAddFeat = { characterId, feat -> viewModel.handleIntent(CharacterSheetIntents.AddFeat(characterId, feat)) },
        onRemoveFeat = { characterId, featId -> viewModel.handleIntent(CharacterSheetIntents.RemoveFeat(characterId, featId))},

        onLoadWeapons = { characterId -> viewModel.handleIntent(CharacterSheetIntents.LoadWeapons(characterId)) },
        onUpdateWeapon = { characterId, weaponId -> viewModel.handleIntent(CharacterSheetIntents.UpdateWeapon(characterId, weaponId)) },
        onCreateWeapon = { characterId, weapon -> viewModel.handleIntent(CharacterSheetIntents.AddWeapon(characterId, weapon)) },
        onRemoveWeapon = { characterId, weaponId -> viewModel.handleIntent(CharacterSheetIntents.RemoveWeapon(characterId, weaponId)) }
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
    featState: FeatUiState,
    onBack: () -> Unit,

    onLoadCharacter: (Long) -> Unit,
    onUpdateCharacter: (CharacterSheet) -> Unit,

    onLoadRaces: () -> Unit,
    onLoadClasses: () -> Unit,
    onLoadBackgrounds: () -> Unit,

    onLoadSpells: () -> Unit,
    onAddSpell: (Long, Spell) -> Unit,
    onRemoveSpell: (Long, Long) -> Unit,

    onLoadItems: (Long) -> Unit,
    onCreateItem: (Long, Item) -> Unit,
    onRemoveItem: (Long, Long) -> Unit,

    onLoadWeapons: (Long) -> Unit,
    onCreateWeapon: (Long, Weapon) -> Unit,
    onUpdateWeapon: (Long, Weapon) -> Unit,
    onRemoveWeapon: (Long, Long) -> Unit,

    onLoadFeats: () -> Unit,
    onAddFeat: (Long, Feat) -> Unit,
    onRemoveFeat: (Long, Long) -> Unit

) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = CharacterSheetTab.entries

    val characterSheet = characterState.characterSheet
    val characterClass = classesState.classes.firstOrNull { it.id == characterSheet.playerClassId }

    LaunchedEffect(Unit) {
        Log.d("CharacterState Data", "${characterState.characterId}")
        onLoadCharacter(characterState.characterId)
        onLoadClasses()
        onLoadRaces()
        onLoadBackgrounds()
        onLoadFeats()
        onLoadItems(characterState.characterId)
        onLoadWeapons(characterState.characterId)
        onLoadSpells()
    }

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

                    onLevelChange = { level ->
                        onUpdateCharacter(characterSheet.copy(level = level))
                    },
                    onNameChange = { name ->
                        onUpdateCharacter(characterSheet.copy(name = name))
                    },
                    onRaceChange = { race ->
                        onUpdateCharacter(characterSheet.copy(race = race))
                    },
                    onClassChange = { playerClass ->
                        onUpdateCharacter(characterSheet.copy(playerClassId = playerClass))
                    },
                    onBackgroundChange = { background ->
                        onUpdateCharacter(characterSheet.copy(background = background))
                    },
                    onImageChange = {},
                    onProficiencyBonusChange = { pb ->
                        onUpdateCharacter(characterSheet.copy(proficiencyBonus = pb))
                    },
                    onArmorClassChange = { ac ->
                        onUpdateCharacter(characterSheet.copy(armorClass = ac))
                    },
                    onInitiativeChange = { initiative ->
                        onUpdateCharacter(characterSheet.copy(initiative = initiative))
                    },
                    onSTRChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.STR to score)))
                    },
                    onDEXChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.DEX to score)))
                    },
                    onCONChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.CON to score)))
                    },
                    onINTChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.INT to score)))
                    },
                    onWISChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.WIS to score)))
                    },
                    onCHAChange = { score ->
                        onUpdateCharacter(characterSheet.copy( stats = characterSheet.stats + (AbilityScores.CHA to score)))
                    },
                    onCurrentHPChange = { hp ->
                        onUpdateCharacter(characterSheet.copy(currentHp = hp))
                    },
                    onMaxHPChange = { hp ->
                        onUpdateCharacter(characterSheet.copy(maxHp = hp))
                    },
                    onTHPChange = { thp ->
                        onUpdateCharacter(characterSheet.copy(temporaryHp = thp))
                    },
                    onCurrentHitDiceChange = { die ->
                        onUpdateCharacter(characterSheet.copy(currentHitDice = die))
                    },
                    onSuccessDST = { dt ->
                        onUpdateCharacter(characterSheet.copy(deathSaveSuccesses = dt))
                    },
                    onFailedDST = { dt ->
                        onUpdateCharacter(characterSheet.copy(deathSaveFailures = dt))
                    },
                )
                CharacterSheetTab.FEATURES -> FeaturesTabContent(
                    characterId = characterState.characterSheet.id!!,
                    classFeatures = characterClass?.features?.filterKeys { it in 1..characterSheet.level } ?: emptyMap(),
                    raceFeatures = characterSheet.race?.features ?: emptyList(),
                    backgroundFeatures = characterSheet.background?.feature,
                    featList = featState.feats,
                    featCharacter = characterSheet.feats,
                    onAddFeat = { feat ->
                        onAddFeat(characterState.characterId, feat)
                    },
                    onRemoveFeat = { id ->
                        onRemoveFeat( characterState.characterId, id)
                    }
                )
                CharacterSheetTab.WEAPONS -> WeaponsTabContent(
                    weapons = weaponsState.characterWeapons,
                    proficiencyBonus = characterSheet.proficiencyBonus,
                    onAddWeapon = { weapon ->
                        onCreateWeapon(characterState.characterId, weapon)
                    },
                    onProficiencyChange = { weapon ->
                        onUpdateWeapon(characterState.characterId, weapon)
                    },
                    onRemoveWeapon = { weaponId ->
                        onRemoveWeapon(characterState.characterId, weaponId)
                    }
                )
                CharacterSheetTab.INVENTORY -> InventoryTabContent(
                    inventory = inventoryState.characterInventory,
                    onAddItem = { item ->
                        onCreateItem(characterState.characterId, item)
                    },
                    onRemoveItem = { itemId ->
                        onRemoveItem(characterState.characterId, itemId)
                    }
                )
                CharacterSheetTab.SPELLS -> SpellsTabContent(
                    spells = spellsState.spells,
                    characterSpells = characterSheet.spells,
                    castingScore = characterClass?.spellcasting?.spellcastingAbility ?: AbilityScores.INT,
                    castingScoreValue = characterSheet.stats[characterClass?.spellcasting?.spellcastingAbility] ?: 0,
                    spellSlots = characterClass?.spellcasting?.spellSlotProgression[characterSheet.level],
                    proficiencyBonus = characterSheet.proficiencyBonus,
                    spentSpellSlots = characterSheet.spellSlotUsed,
                    onSpentSpellSlotsChange = { slots ->
                        onUpdateCharacter(characterSheet.copy(spellSlotUsed = slots))
                    },
                    onAddSpell = { spell ->
                        onAddSpell( characterState.characterId, spell)
                    },
                    onRemoveSpell = { id ->
                        onRemoveSpell( characterState.characterId, id)
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
                    onNotesChange = { notes ->
                        onUpdateCharacter(characterSheet.copy(notes = notes))
                    }
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
    val fakeFeatState = FeatUiState(
        isLoading = isLoading,
        feats = FakeFeats.all
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
            featState = fakeFeatState,
            onBack = {},
            onLoadCharacter = {},
            onLoadRaces = {},
            onLoadClasses = {},
            onLoadBackgrounds = {},
            onLoadItems = {},
            onLoadWeapons = {},
            onLoadSpells = {},
            onUpdateCharacter = {},
            onCreateItem = { _, _ -> },
            onCreateWeapon = { _, _ ->  },
            onUpdateWeapon = {_, _ ->},
            onAddSpell = { _, _ ->  },
            onAddFeat = { _, _ ->  },
            onLoadFeats = {},
            onRemoveSpell = { _, _ ->  },
            onRemoveItem = { _, _-> },
            onRemoveWeapon = { _, _->  },
            onRemoveFeat = { _, _ ->  }
        )
    }
}