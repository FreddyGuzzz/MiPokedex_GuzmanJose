package com.guzmanjose.mipokedex_guzmanjose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guzmanjose.mipokedex_guzmanjose.R
import com.guzmanjose.mipokedex_guzmanjose.data.getPokemonByNumber
import com.guzmanjose.mipokedex_guzmanjose.data.pokemonList
import com.guzmanjose.mipokedex_guzmanjose.domain.Pokemon
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme
import com.guzmanjose.mipokedex_guzmanjose.utilities.getColorByType

private val Amarillo = Color(0xFFF6D64A)
private val Rojo = Color(0xFFD94A45)
private val Gris = Color(0xFF555555)

@Composable
fun PokemonDetailScreen(
    innerPadding: PaddingValues,
    pokemonNumber: Int,
    onNavigateToDetail: (Int) -> Unit = {}
) {
    val pokemon = getPokemonByNumber(pokemonNumber)

    if (pokemon == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Pokémon no encontrado")
        }
        return
    }

    val index = pokemonList.indexOfFirst { it.number == pokemon.number }
    val anterior = pokemonList.getOrNull(index - 1)
    val siguiente = pokemonList.getOrNull(index + 1)

    var favorito by remember(pokemon.number) { mutableStateOf(pokemon.favorite) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Amarillo)
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("MI POKÉDEX", fontSize = 13.sp, color = Gris)
                Text(
                    pokemon.name,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF252525)
                )
                Text("#%03d".format(pokemon.number), color = Gris)
            }
            IconButton(onClick = { favorito = !favorito }) {
                Icon(
                    painter = painterResource(R.drawable.ic_star_white),
                    contentDescription = if (favorito) "Quitar de favoritos" else "Marcar favorito",
                    tint = if (favorito) Rojo else Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.pokeballpokedex),
                contentDescription = null,
                modifier = Modifier.size(220.dp),
                alpha = 0.25f
            )
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(210.dp)
            )
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    pokemon.type.split("/").forEach { tipo ->
                        val tipoColors = getColorByType(tipo)
                        Text(
                            text = tipo.trim(),
                            modifier = Modifier
                                .background(tipoColors.first, RoundedCornerShape(16.dp))
                                .padding(horizontal = 24.dp, vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            color = tipoColors.second
                        )
                    }
                }
                Spacer(Modifier.height(24.dp))
                DatoPokemon("Altura", "${pokemon.height} m")
                DatoPokemon("Peso", "${pokemon.weight} kg")
                DatoPokemon("Habilidad", pokemon.ability)
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                Text(
                    text = pokemon.description,
                    textAlign = TextAlign.Center,
                    color = Gris,
                    lineHeight = 24.sp
                )
            }
        }

        if (anterior != null || siguiente != null) {
            Spacer(Modifier.height(24.dp))
            Text(
                "Pokémon cercanos",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Gris
            )
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (anterior != null) {
                    PokemonCercano(anterior, onNavigateToDetail, Modifier.weight(1f))
                } else {
                    Spacer(Modifier.weight(1f))
                }
                if (siguiente != null) {
                    PokemonCercano(siguiente, onNavigateToDetail, Modifier.weight(1f))
                } else {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun DatoPokemon(titulo: String, valor: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(titulo, modifier = Modifier.weight(1f), color = Rojo, fontWeight = FontWeight.Bold)
        Text(valor, modifier = Modifier.weight(1f), color = Gris, textAlign = TextAlign.End)
    }
}

@Composable
fun PokemonCercano(
    pokemon: Pokemon,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.clickable { onClick(pokemon.number) },
        color = Color.White,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(64.dp)
            )
            Text(pokemon.name, fontWeight = FontWeight.Bold, color = Gris)
            Text("#%03d".format(pokemon.number), fontSize = 12.sp, color = Gris)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PokemonDetailScreenPreview() {
    PokedexTheme {
        PokemonDetailScreen(PaddingValues(0.dp), 25)
    }
}