package com.guzmanjose.mipokedex_guzmanjose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guzmanjose.mipokedex_guzmanjose.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.domain.Pokemon
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues) {
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    PokedexTheme {
        MenuPokedex(pokemonList, PaddingValues(0.dp))
    }
}