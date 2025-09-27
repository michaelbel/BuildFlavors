package org.michaelbel.buildflavors.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = RichGold,
    onPrimary = DeepChoco,
    primaryContainer = SoftGold,
    onPrimaryContainer = DeepChoco,
    secondary = DeepChoco,
    onSecondary = SoftGold,
    secondaryContainer = DeepChocoElevated,
    onSecondaryContainer = SoftGold,
    background = PaleGold,
    onBackground = DeepChoco,
    surface = PaleGold,
    onSurface = DeepChoco,
    surfaceVariant = SoftGold
)
private val DarkColorScheme = darkColorScheme(
    primary = RichGold,
    onPrimary = DeepChoco,
    primaryContainer = DeepChocoElevated,
    onPrimaryContainer = SoftGold,
    secondary = SoftGold,
    onSecondary = DeepChoco,
    secondaryContainer = DeepChocoElevated,
    onSecondaryContainer = SoftGold,
    background = DeepChoco,
    onBackground = SoftGold,
    surface = DeepChoco,
    onSurface = SoftGold,
    surfaceVariant = DeepChocoElevated
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme,
        content = content
    )
}