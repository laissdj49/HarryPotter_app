package com.lais.harrypotter.characters.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation

@Composable
fun Characters(
    character: HarryPotterPresentation,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(150.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF2B2A2A)

    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp)
                        .size(80.dp)
                        .clip(CircleShape)
                        .align(alignment = Alignment.Center),
                    model = character.imageUrl,
                    contentDescription = null,
                )
                if (character.house.icon != null) {
                    Image(
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 2.dp)
                            .size(22.dp)
                            .align(Alignment.BottomStart),
                        painter = painterResource(id = character.house.icon),
                        contentDescription = ""
                    )
                }
            }
            Text(
                modifier = Modifier.padding(
                    bottom = 4.dp,
                    start = 8.dp,
                    end = 8.dp,
                    top = 4.dp
                ),
                text = character.name,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                maxLines = 2
            )
        }
    }
}