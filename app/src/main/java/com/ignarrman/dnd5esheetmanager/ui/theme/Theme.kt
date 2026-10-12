
package com.ignarrman.dnd5esheetmanager.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = AppPrimary,
    onPrimary = AppBackground,

    secondary = AppSecondary,
    onSecondary = AppBackground,

    tertiary = AppTertiary,
    onTertiary = AppBackground,

    background = AppBackground,
    onBackground = AppOnBackground,

    surface = AppSurface,
    onSurface = AppOnSurface,

    surfaceVariant = AppSurfaceVariant,
    onSurfaceVariant = AppOnSurfaceVariant,

    outline = AppOutline,
    error = AppError,
    onError = AppBackground
)

private val LightColorScheme = lightColorScheme(
    primary = AppLightPrimary,
    onPrimary = AppLightSurface,

    secondary = AppLightSecondary,
    onSecondary = AppLightSurface,

    tertiary = AppLightTertiary,
    onTertiary = AppLightSurface,

    background = AppLightBackground,
    onBackground = AppLightOnBackground,

    surface = AppLightSurface,
    onSurface = AppLightOnSurface,

    surfaceVariant = AppLightSurfaceVariant,
    onSurfaceVariant = AppLightOnSurfaceVariant,

    outline = AppLightOutline,
    error = AppLightError,
    onError = AppLightSurface
)

@Composable
fun _5eSheetManagerTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
