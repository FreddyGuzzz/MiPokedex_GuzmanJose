package com.guzmanjose.mipokedex_guzmanjose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColoresPokedex = lightColorScheme(
    primary = Color(0xFFD94A45),
    background = Color(0xFFF6D64A),
    surface = Color.White,
    onSurface = Color(0xFF252525)
)

@Composable
fun PokedexTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColoresPokedex,
        typography = Typography,
        content = content
    )
}
