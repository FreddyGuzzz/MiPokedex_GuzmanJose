package com.guzmanjose.mipokedex_guzmanjose.navegation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val pokemon: Int)