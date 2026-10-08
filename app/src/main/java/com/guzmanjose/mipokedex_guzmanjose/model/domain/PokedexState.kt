package com.guzmanjose.mipokedex_guzmanjose.model.domain

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lastCaptured: Pokemon? = null
)
