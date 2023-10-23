package com.lais.harrypotter.characters.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import com.lais.harrypotter.utils.ColorApp

@Composable
fun HarryPotterDetail(harryPotterDetail: HarryPotterPresentation) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(200.dp),
            model = harryPotterDetail.imageUrl,
            contentDescription = null
        )

        Text(
            text = harryPotterDetail.name,
            color = colorResource(id = R.color.white),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        Column(modifier = Modifier.align(Alignment.Start)) {

            Text(
                text = stringResource(id = R.string.ancestryy),
                color = colorResource(id = R.color.white),
                style = TextStyle(fontWeight = FontWeight.Bold),
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = harryPotterDetail.ancestry.name,
                color = colorResource(id = R.color.white),
            )
            Text(
                text = stringResource(id = R.string.yearofbirth),
                color = colorResource(id = R.color.white),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = harryPotterDetail.yearOfBirth.toString(),
                color = colorResource(id = R.color.white)
            )
            Text(
                text = stringResource(id = R.string.house),
                color = colorResource(id = R.color.white),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = harryPotterDetail.house.name,
                color = colorResource(id = R.color.white)
            )
            if (harryPotterDetail.patronus.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.patronus),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.patronus,
                    color = colorResource(id = R.color.white)
                )
            }
            if (harryPotterDetail.wand.core.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.wand),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.white)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.wand.core,
                    color = colorResource(id = R.color.white),
                )
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailCompose(
    harryCharacterDetail: HarryPotterPresentation,
    state: SheetState,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = state,
        containerColor = ColorApp.backgroundGray
    ) {
        HarryPotterDetail(harryPotterDetail = harryCharacterDetail)
    }
}