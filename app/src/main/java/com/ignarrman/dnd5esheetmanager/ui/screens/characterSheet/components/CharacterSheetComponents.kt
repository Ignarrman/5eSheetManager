package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.getScoreBonus
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.getScoreProficiencyBonus
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Speed

private val FrameColor = Color(0xFF526575)
private val PanelColor = Color(0xFF263440)
private val InnerPanelColor = Color(0xFF1D2A34)
private val TextColor = Color(0xFFF1F4F7)

@Composable
fun AbilityScoreCard(
    score: Int,
    scoreName: String,
    modifier: Modifier = Modifier,
    bonus: Int = (score - 10) / 2
) {
    Box(
        modifier = modifier
            .padding(bottom = 14.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .size(width = 108.dp, height = 120.dp)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(PanelColor)
                .border(
                    width = 2.dp,
                    color = FrameColor,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(
                    horizontal = 6.dp,
                    vertical = 8.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = scoreName.uppercase(),
                color = TextColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(InnerPanelColor)
                    .border(
                        width = 1.dp,
                        color = FrameColor,
                        shape = RoundedCornerShape(5.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "%+d".format(bonus),
                    color = TextColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-0).dp)
                .width(56.dp)
                .height(28.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF10151B))
                .border(
                    width = 2.dp,
                    color = FrameColor,
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = score.toString(),
                color = TextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun SavingThrowCard(
    score: Int,
    scoreName: String,
    proficiency: Boolean,
    proficiencyBonus: Int,
    modifier: Modifier = Modifier
) {
    val frameColor = MaterialTheme.colorScheme.outline
    val panelColor = Color(0xFF263440)
    val innerPanelColor = Color(0xFF1D2A34)
    val textColor = Color(0xFFF1F4F7)

    Row(
        modifier = modifier
            .size(width = 170.dp, height = 50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(panelColor)
            .border(
                width = 1.5.dp,
                color = frameColor,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .background(
                    color = if (proficiency) {
                        textColor
                    } else {
                        Color.Transparent
                    },
                    shape = CircleShape
                )
                .border(
                    width = 1.5.dp,
                    color = textColor,
                    shape = CircleShape
                )
        )

        Text(
            text = scoreName.uppercase(),
            modifier = Modifier.weight(1f),
            color = textColor,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )

        Box(
            modifier = Modifier
                .background(
                    color = innerPanelColor,
                    shape = RoundedCornerShape(6.dp)
                )
                .border(
                    width = 1.dp,
                    color = frameColor,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "%+d".format(
                    getScoreProficiencyBonus(
                        score = score,
                        proficiency = proficiency,
                        expertise = false,
                        proficiencyBonus = proficiencyBonus
                    )
                ),
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProficiencyBonusCard(
    modifier: Modifier,
    proficiencyBonus: Int
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Proficiency Bonus".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "%+d".format(proficiencyBonus),
            color = textColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun InitiativeCard(
    modifier: Modifier,
    initiative: Int? = null
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Initiative".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        if (initiative == null) {
            Text(
                text = "—",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        } else {
            Text(
                text = "%+d".format(initiative),
                color = textColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SpeedCard(
    modifier: Modifier = Modifier,
    speeds: Speed? = null
) {
    val textColor = Color(0xFFF1F4F7)

    val speedEntries = if (speeds != null) {
        listOf(
            "Land" to speeds.land,
            "Swim" to speeds.swim,
            "Climb" to speeds.climb,
            "Fly" to speeds.fly
        ).filter { (_, distance) -> distance != null }
    } else {
        emptyList()
    }

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Speed".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        if (speedEntries.isEmpty()) {
            Text(
                text = "—",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )
        } else {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2,
                maxLines = 2
            ) {
                speedEntries.forEach { speed ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = speed.first,
                            fontSize = 16.sp,
                            color = textColor
                        )

                        Text(
                            text = "${speed.second} ft",
                            fontSize = 20.sp,
                            color = textColor,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun HitPointsCard(
    currentHp: Int,
    maxHp: Int,
    temporaryHp: Int,
    modifier: Modifier = Modifier
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Hit Points",
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$currentHp",
                    color = textColor,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "/ $maxHp HP",
                    color = textColor,
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            if (temporaryHp > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = " + $temporaryHp THP",
                        color = textColor,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun HitDiceCard(
    modifier: Modifier = Modifier,
    dieType: String?,
    available: Int,
    total: Int
) {

    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "Hit Dice",
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "$available",
                color = textColor,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "/ ${total}d${dieType ?: "(No_dice)"}",
                color = textColor,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun DeathSavesCard(
    modifier: Modifier,
    successDeathSaves: Int,
    failureDeathSaves: Int
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "Death Saves",
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "WORK IN PROGRESS",
                color = textColor,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PassivePerceptionCard(
    modifier: Modifier,
    perceptionScore: Int
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Passive Perception".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "$perceptionScore",
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ArmorClassCard(
    modifier: Modifier,
    armorClass: Int?
){
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Armor Class".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(8.dp))
        if (armorClass == null) {
            Text(
                text = "—",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        } else {
            Text(
                text = "$armorClass",
                color = textColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FeatureDropdown(
    feature: Feature,
    modifier: Modifier = Modifier,
    initiallyExpanded: Boolean = false
) {
    var expanded by remember (feature.id, feature.name) {
        mutableStateOf(initiallyExpanded)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatureDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = feature.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feature description"
                } else {
                    "Expand feature description"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = feature.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun FeatureSection(
    title: String,
    features: List<Feature>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        features.forEach { feature ->
            FeatureDropdown(
                feature = feature
            )
        }
    }
}

@Composable
fun FeatDropdown(
    feat: Feat,
    modifier: Modifier = Modifier,
    initiallyExpanded: Boolean = false
) {
    var expanded by remember(feat.id, feat.name) {
        mutableStateOf(initiallyExpanded)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = feat.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feat details"
                } else {
                    "Expand feat details"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FeatDetail(
                    label = "Description",
                    value = feat.description
                )

                FeatDetail(
                    label = "Prerequisite",
                    value = feat.prerequisite
                )

                FeatDetail(
                    label = "Ability Bonus",
                    value = feat.abilityBonus
                )
            }
        }
    }
}

@Composable
private fun FeatDetail(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value.ifBlank { "None" },
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FeatSection(
    feats: List<Feat>,
    modifier: Modifier = Modifier,
    title: String = "Feats"
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        feats.forEach { feat ->
            FeatDropdown(
                feat = feat
            )
        }
    }
}