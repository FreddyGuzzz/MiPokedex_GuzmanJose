package com.guzmanjose.mipokedex_guzmanjose.screens

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.guzmanjose.mipokedex_guzmanjose.data.getPokemonByNumber

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Int){
    val pokemon = getPokemonByNumber(pokemon)
    Column(Modifier.padding(innerPadding)){

        Text(pokemon.name)
        Image(painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image")

    }
}