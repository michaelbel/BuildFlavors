package org.michaelbel.buildflavors.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private object Colors {
    val PaleGold = Color(0xFFFEF4D5)
    val SoftGold = Color(0xFFF1E49A)
    val RichGold = Color(0xFFE6D17B)
    val DeepChoco = Color(0xFF2C1810)
    val DeepChocoElevated = Color(0xFF463025)
}
private val LightScheme = lightColorScheme(
    primary = Colors.RichGold,
    onPrimary = Colors.DeepChoco,
    primaryContainer = Colors.SoftGold,
    onPrimaryContainer = Colors.DeepChoco,
    secondary = Colors.DeepChoco,
    onSecondary = Colors.SoftGold,
    secondaryContainer = Colors.DeepChocoElevated,
    onSecondaryContainer = Colors.SoftGold,
    background = Colors.PaleGold,
    onBackground = Colors.DeepChoco,
    surface = Colors.PaleGold,
    onSurface = Colors.DeepChoco,
    surfaceVariant = Colors.SoftGold,
    outline = Color(0xFF8D7A50)
)
private val DarkScheme = darkColorScheme(
    primary = Colors.RichGold,
    onPrimary = Colors.DeepChoco,
    primaryContainer = Colors.DeepChocoElevated,
    onPrimaryContainer = Colors.SoftGold,
    secondary = Colors.SoftGold,
    onSecondary = Colors.DeepChoco,
    secondaryContainer = Colors.DeepChocoElevated,
    onSecondaryContainer = Colors.SoftGold,
    background = Colors.DeepChoco,
    onBackground = Colors.SoftGold,
    surface = Colors.DeepChoco,
    onSurface = Colors.SoftGold,
    surfaceVariant = Colors.DeepChocoElevated,
    outline = Color(0xFFD9C999)
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkScheme else LightScheme,
        content = content
    )
}