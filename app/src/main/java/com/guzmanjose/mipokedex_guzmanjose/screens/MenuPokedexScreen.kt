package com.guzmanjose.mipokedex_guzmanjose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guzmanjose.mipokedex_guzmanjose.components.FavoritesRow
import com.guzmanjose.mipokedex_guzmanjose.components.PokedexGrid
import com.guzmanjose.mipokedex_guzmanjose.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues) {
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
        FavoritesRow(pokemonList.filter { it.favorite })

        Text(
            text = "Todos mis pokemones",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
        PokedexGrid(pokemonList)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    PokedexTheme {
        MenuPokedexScreen(PaddingValues(0.dp))
    }
}