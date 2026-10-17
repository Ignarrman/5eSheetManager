package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeBackground
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeRace
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun GeneralTabContent(
    characterSheet: CharacterSheet,
    race: Race?,
    background: Background?,
    playerClass: PlayerClass?,

    races: List<Race>,
    classes: List<PlayerClass>,
    backgrounds: List<Background>,

    onNameChange: (String) -> Unit,
    onRaceChange: (String) -> Unit,
    onClassChange: (String) -> Unit,
    onBackgroundChange: (String) -> Unit,
) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Spacer(Modifier.width(60.dp))
                ProfileLevelBox(
                    level = characterSheet.level,
                    onValueChange = {
                        // TODO
                    }
                )
            }

            ProfileBox(
                characterName = characterSheet.name,
                raceName = race?.name ?: "No Race",
                backgroundName = background?.name ?: "No Background",
                className = playerClass?.name ?: "No Class",

                races = races.map { it.name },
                classes = classes.map { it.name },
                backgrounds = backgrounds.map { it.name },

                onNameChange = onNameChange,
                onRaceChange = onRaceChange,
                onClassChange = onClassChange,
                onBackgroundChange = onBackgroundChange,
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                ProficiencyBonusCard(
                    modifier = Modifier
                        .weight(0.4f)
                        .size(height = 120.dp, width = 120.dp),
                    proficiencyBonus = characterSheet.proficiencyBonus,
                    onValueChange = {
                        // TODO
                    }
                )
                ArmorClassCard(
                    modifier = Modifier.size(height = 120.dp, width = 110.dp),
                    armorClass = characterSheet.armorClass,
                    onValueChange = {
                        // TODO
                    }
                )

                InitiativeCard(
                    modifier = Modifier.size(height = 120.dp, width = 100.dp),
                    initiative = characterSheet.proficiencyBonus,
                    onValueChange = {
                        // TODO
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                SpeedCard(
                    modifier = Modifier.width(200.dp),
                    speeds = race?.speed
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 3,
                maxLines = 2
            ) {
                AbilityScores.entries.forEach { it ->
                    AbilityScoreCard(
                        score = characterSheet.stats[it] ?: 10,
                        scoreName = it.statName,
                        onValueChange = {
                            // TODO
                        }
                    )
                }
            }

            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2,
                maxLines = 3
            ) {
                AbilityScores.entries.forEach { it ->
                    SavingThrowCard(
                        score = characterSheet.stats[it] ?: 10,
                        scoreName = it.statName,
                        proficiency = characterSheet.savingThrowProficiencies.contains(it),
                        proficiencyBonus = 2
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            HitPointsCard(
                modifier = Modifier,
                currentHp = characterSheet.currentHp ?: 0,
                maxHp = characterSheet.maxHp ?: 0,
                temporaryHp = characterSheet.temporaryHp,
                onCurrentHPChange = {
                    // TODO
                },
                onMaxHPChange = {
                    // TODO
                },
                onTHPChange = {
                    // TODO
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HitDiceCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    dieType = playerClass?.hitDice.toString(),
                    available = characterSheet.currentHitDice,
                    total = characterSheet.level,
                    onValueChange = {
                        // TODO
                    }
                )
                PassivePerceptionCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    perceptionScore = characterSheet.skills[Skill.PERCEPTION] ?: 0
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            DeathSavesCard(
                modifier = Modifier,
                successDeathSaves = characterSheet.deathSaveSuccesses,
                failureDeathSaves = characterSheet.deathSaveFailures,
                onSetToOneSuccess = {
                    // TODO Set to 1
                },
                onSetToTwoSuccess = {
                    // TODO Set to 2
                },
                onSetToThreeSuccess = {
                    // TODO Set to 3
                },
                onSetToOneFailed = {
                    // TODO Set to 1
                },
                onSetToTwoFailed = {
                    // TODO Set to 2
                },
                onSetToThreeFailed = {
                    // TODO Set to 3
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GeneralTabContentPreview() {

    val character = FakeCharacterSheet.thorin
    val race = FakeRace.dragonborn
    val background = FakeBackground.noble
    val playerClass = FakePlayerClass.fighter

    _5eSheetManagerTheme() {
        GeneralTabContent(
            characterSheet = character,
            race = race,
            background = background,
            playerClass = playerClass,

            races = emptyList(),
            classes = emptyList(),
            backgrounds = emptyList(),

            onNameChange = {},
            onRaceChange = {},
            onClassChange = {},
            onBackgroundChange = {}
        )
    }
}