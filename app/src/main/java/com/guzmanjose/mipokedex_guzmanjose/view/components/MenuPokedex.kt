package com.guzmanjose.mipokedex_guzmanjose.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guzmanjose.mipokedex_guzmanjose.model.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.model.domain.Pokemon
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon)
        }
    }
}

@Composable
fun FavoritesRow(favoriteList: List<Pokemon>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        items(favoriteList) { pokemon ->
            FavoritePokemon(pokemon)
        }
    }
}

@Composable
fun PokedexGrid(pokemonList: List<Pokemon>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonCell(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    PokedexTheme {
        MenuPokedex(pokemonList)
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesRowPreview() {
    PokedexTheme {
        FavoritesRow(pokemonList.filter { it.favorite })
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexGridPreview() {
    PokedexTheme {
        PokedexGrid(pokemonList)
    }
}