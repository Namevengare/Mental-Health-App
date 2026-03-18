package com.example.mentalhealthapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = KhakiGreen,
    onPrimary = PineTree,
    primaryContainer = PineTree,
    onPrimaryContainer = KhakiGreen,
    
    secondary = MacaroonGreen,
    onSecondary = PineTree,
    secondaryContainer = PineTree,
    onSecondaryContainer = MacaroonGreen,
    
    tertiary = Misty,
    onTertiary = PineTree,
    tertiaryContainer = PineTree,
    onTertiaryContainer = Misty,
    
    background = PineTree,
    onBackground = Misty,
    surface = PineTree,
    onSurface = Misty,
    surfaceVariant = Color(0xFF3E4029), // Una variante oscura del Pine Tree
    onSurfaceVariant = MacaroonGreen
)

private val LightColorScheme = lightColorScheme(
    primary = PineTree,
    onPrimary = Misty,
    primaryContainer = KhakiGreen,
    onPrimaryContainer = PineTree,
    
    secondary = KhakiGreen,
    onSecondary = Misty,
    secondaryContainer = MacaroonGreen,
    onSecondaryContainer = PineTree,
    
    tertiary = MacaroonGreen,
    onTertiary = PineTree,
    tertiaryContainer = Misty,
    onTertiaryContainer = PineTree,
    
    background = Misty,
    onBackground = PineTree,
    surface = Misty,
    onSurface = PineTree,
    surfaceVariant = MacaroonGreen.copy(alpha = 0.5f),
    onSurfaceVariant = PineTree
)

@Composable
fun MentalHealthAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
