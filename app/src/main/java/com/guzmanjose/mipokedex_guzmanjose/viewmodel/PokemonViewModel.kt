package com.guzmanjose.mipokedex_guzmanjose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.guzmanjose.mipokedex_guzmanjose.model.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.model.domain.Pokemon

class PokemonViewModel: ViewModel() {
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set
    var capturedPokemon by mutableStateOf(listOf<Pokemon>())
        private set
    var gonePokemon by mutableStateOf(false)
        private set

    fun searchPokemon(){
        wildPokemon = pokemonList.random()
    }

    fun capturePokemon(){
        wildPokemon?.let {
            val isCaptured = (1..2).random()
            if (isCaptured == 1){
                capturedPokemon = capturedPokemon + it
                gonePokemon = false
                wildPokemon = null
            }else{
                gonePokemon = true
                wildPokemon = null
            }
        }
    }
}