package com.guzmanjose.mipokedex_guzmanjose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.PokedexTheme

private val Amarillo = Color(0xFFF6D64A)
private val Rojo = Color(0xFFD94A45)
private val Gris = Color(0xFF555555)

@Composable
fun PantallaPokedex() {
    var favorito by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Amarillo)
            .safeDrawingPadding()
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
                    stringResource(R.string.pokemon_name),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF252525)
                )
                Text(stringResource(R.string.pokemon_number), color = Gris)
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
            modifier = Modifier.fillMaxWidth().height(240.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.pokeballpokedex),
                contentDescription = null,
                modifier = Modifier.size(220.dp),
                alpha = 0.25f
            )
            Image(
                painter = painterResource(R.drawable.pikachupokedex),
                contentDescription = "Pikachu",
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
                Text(
                    text = stringResource(R.string.type_electric),
                    modifier = Modifier
                        .background(Amarillo, RoundedCornerShape(16.dp))
                        .padding(horizontal = 24.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(Modifier.height(24.dp))
                DatoPokemon(stringResource(R.string.label_height), stringResource(R.string.value_height))
                DatoPokemon(stringResource(R.string.label_weight), stringResource(R.string.value_weight))
                DatoPokemon(stringResource(R.string.label_ability), stringResource(R.string.value_ability))
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                Text(
                    text = stringResource(R.string.pokemon_description),
                    textAlign = TextAlign.Center,
                    color = Gris,
                    lineHeight = 24.sp
                )
            }
        }

        Spacer(Modifier.height(24.dp))
        Text("Pokémon cercanos", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, color = Gris)
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PokemonCercano(
                nombre = "Arbok",
                numero = "N.º 0024",
                imagen = R.drawable.arbokpokedex,
                modifier = Modifier.weight(1f)
            )
            PokemonCercano(
                nombre = "Raichu",
                numero = "N.º 0026",
                imagen = R.drawable.raichupokedex,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun DatoPokemon(titulo: String, valor: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(titulo, modifier = Modifier.weight(1f), color = Rojo, fontWeight = FontWeight.Bold)
        Text(valor, modifier = Modifier.weight(1f), color = Gris, textAlign = TextAlign.End)
    }
}

@Composable
fun PokemonCercano(nombre: String, numero: String, imagen: Int, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, color = Color.White, shape = RoundedCornerShape(16.dp)) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(imagen), contentDescription = nombre, modifier = Modifier.size(64.dp))
            Text(nombre, fontWeight = FontWeight.Bold, color = Gris)
            Text(numero, fontSize = 12.sp, color = Gris)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun VistaPreviaPokedex() {
    PokedexTheme {
        PantallaPokedex()
    }
}
