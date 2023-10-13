package com.lais.harrypotter.staff.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lais.harrypotter.staff.domain.StaffPresentation


@Composable
fun Staff(
    staff: StaffPresentation,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(150.dp)
            .fillMaxWidth()
    ) {

        AsyncImage(
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxSize(),
            model = staff.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 6.dp, end = 6.dp, bottom = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.White)
                .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp),
            text = staff.name,
            color = Color.Black,
            textAlign = TextAlign.Center,
            maxLines = 2
        )

    }
}


