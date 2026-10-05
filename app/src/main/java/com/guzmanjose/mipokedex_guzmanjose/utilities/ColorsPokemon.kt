package com.guzmanjose.mipokedex_guzmanjose.utilities

import androidx.compose.ui.graphics.Color
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.*

fun getColorByType(type: String): Pair<Color, Color> {
    val mainType = type.substringBefore("/").trim()

    return when (mainType) {
        "Normal" -> Pair(Normal, OffWhite)
        "Water" -> Pair(Water, OffWhite)
        "Fire" -> Pair(Fire, OffWhite)
        "Psych", "Psychic" -> Pair(Psych, OffWhite)
        "Ghost" -> Pair(Ghost, OffWhite)
        "Dragon" -> Pair(Dragon, OffWhite)
        "Dark" -> Pair(Dark, OffWhite)

        "Bug" -> Pair(Bug, DarkGray)
        "Poison" -> Pair(Poison, DarkGray)
        "Grass" -> Pair(Grass, DarkGray)
        "Ground" -> Pair(Ground, DarkGray)
        "Rock" -> Pair(Rock, DarkGray)
        "Electric" -> Pair(Electric, DarkGray)
        "Fairy" -> Pair(Fairy, DarkGray)
        "Fight", "Fighting" -> Pair(Fight, DarkGray)
        "Flying" -> Pair(Flying, DarkGray)
        "Ice" -> Pair(Ice, DarkGray)

        else -> Pair(Normal, OffWhite)
    }
}