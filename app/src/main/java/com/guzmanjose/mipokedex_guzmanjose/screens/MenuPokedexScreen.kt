package com.guzmanjose.mipokedex_guzmanjose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guzmanjose.mipokedex_guzmanjose.R
import com.guzmanjose.mipokedex_guzmanjose.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.Blue
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.Green
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.LightBlue
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.LightGreen
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme
import com.guzmanjose.mipokedex_guzmanjose.components.FavoritesRow
import com.guzmanjose.mipokedex_guzmanjose.components.MenuPokedex
import com.guzmanjose.mipokedex_guzmanjose.components.PokedexGrid

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues,
    onNavigateToDetail: (Int) -> Unit = {}
) {
    var grid by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Text(
            text = "Mis Favoritos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
        FavoritesRow(pokemonList.filter { it.favorite }, onNavigateToDetail)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Todos mis pokemones",
                style = MaterialTheme.typography.titleLarge
            )
            Switch(
                checked = grid,
                onCheckedChange = {
                    grid = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Color.Transparent
                ),
                thumbContent = if (grid) {
                    {
                        Icon(
                            painterResource(R.drawable.grid),
                            contentDescription = "grid icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                } else {
                    {
                        Icon(
                            painterResource(R.drawable.list),
                            contentDescription = "list icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                }
            )
        }

        if (grid) {
            PokedexGrid(pokemonList, onNavigateToDetail)
        } else {
            MenuPokedex(pokemonList, onNavigateToDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    PokedexTheme {
        MenuPokedexScreen(PaddingValues(0.dp))
    }
}