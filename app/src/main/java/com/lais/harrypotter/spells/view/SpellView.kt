package com.lais.harrypotter.spells.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lais.harrypotter.spells.data.response.SpellsResponse

@Composable
fun Spell(spell: SpellsResponse) {
    Box {
        val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Text(
                text = spell.name,
                color = textColor,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp),
                text = spell.description,
                color = textColor,
                textAlign = TextAlign.Justify
            )
        }
    }
}
