package com.guzmanjose.mipokedex_guzmanjose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guzmanjose.mipokedex_guzmanjose.data.bulbasaur
import com.guzmanjose.mipokedex_guzmanjose.domain.Pokemon
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.OffWhite
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme
import com.guzmanjose.mipokedex_guzmanjose.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon, onClick: (Int) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(pokemon.number) }
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(pokemon.image),
            contentDescription = "${pokemon.name.lowercase()} image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Height: ${pokemon.height}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Weight: ${pokemon.weight}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        NumberChip(
            text = pokemon.number.toString(),
            modifier = Modifier.align(Alignment.Top),
            colors = getColorByType(pokemon.type)
        )
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon, onClick: (Int) -> Unit = {}) {
    val colors = getColorByType(pokemon.type)

    Column(
        modifier = Modifier
            .clickable { onClick(pokemon.number) }
            .padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                modifier = Modifier.border(
                    BorderStroke(
                        5.dp,
                        Brush.sweepGradient(
                            listOf(
                                colors.first,
                                OffWhite,
                                colors.first,
                                OffWhite,
                                colors.first
                            )
                        )
                    )
                )
            ) {
                Image(
                    painter = painterResource(pokemon.image),
                    contentDescription = "${pokemon.name.lowercase()} image",
                    modifier = Modifier
                        .padding(5.dp)
                        .width(75.dp)
                )
            }
            NumberChip(
                text = pokemon.number.toString(),
                modifier = Modifier.align(Alignment.BottomEnd),
                colors = colors
            )
        }
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon, onClick: (Int) -> Unit = {}) {
    val colors = getColorByType(pokemon.type)

    Column(
        modifier = Modifier.clickable { onClick(pokemon.number) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = "${pokemon.name.lowercase()} image",
                modifier = Modifier
                    .padding(10.dp)
                    .size(150.dp)
            )
            NumberChip(
                text = pokemon.number.toString(),
                modifier = Modifier.align(Alignment.TopEnd),
                colors = colors
            )
        }
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {
    PokedexTheme {
        PokemonRow(bulbasaur)
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePokemonPreview() {
    PokedexTheme {
        FavoritePokemon(bulbasaur)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCellPreview() {
    PokedexTheme {
        PokemonCell(bulbasaur)
    }
}