package com.guzmanjose.mipokedex_guzmanjose.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.DarkGray
import com.guzmanjose.mipokedex_guzmanjose.ui.theme.Grass

@Composable
fun NumberChip(
    text: String,
    modifier: Modifier = Modifier,
    colors: Pair<Color, Color>
) {
    Row(
        modifier = modifier
            .size(30.dp)
            .padding(5.dp)
            .background(colors.first, CircleShape),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            color = colors.second
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberChipPreview() {
    NumberChip(text = "1", colors = Pair(Grass, DarkGray))
}