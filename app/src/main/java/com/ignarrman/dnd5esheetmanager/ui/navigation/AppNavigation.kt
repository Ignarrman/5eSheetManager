package com.ignarrman.dnd5esheetmanager.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ignarrman.dnd5esheetmanager.ui.navigation.Routes.Home
import com.ignarrman.dnd5esheetmanager.ui.screens.CharacterSheetScreen
import com.ignarrman.dnd5esheetmanager.ui.screens.home.HomeScreen
import com.ignarrman.dnd5esheetmanager.ui.navigation.Routes.CharacterSheet

private const val NAVIGATION_ANIMATION_DURATION = 250

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    onCreateCharacter = {
                        backStack.add(
                            CharacterSheet(characterId = null)
                        )
                    },
                    onLoadCharacter = { characterId ->
                        backStack.add(
                            CharacterSheet(characterId = characterId)
                        )
                    }
                )
            }

            entry<CharacterSheet> { route ->
                CharacterSheetScreen(
                    characterId = route.characterId
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            )
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(
                    NAVIGATION_ANIMATION_DURATION
                )
            )
        }
    )
}