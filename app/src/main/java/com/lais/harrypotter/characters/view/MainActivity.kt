package com.lais.harrypotter.characters.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import com.lais.harrypotter.spells.view.SpellsActivity
import com.lais.harrypotter.staff.view.StaffActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: HarryPotterListViewModel by viewModels { HarryPotterListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                viewModel.listCharacters()
                val character by viewModel.listCharacters.observeAsState(initial = emptyList())
                Column(
                    modifier = Modifier
                        .padding(2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    val onClickSpell = {
                        startActivity(Intent(this@MainActivity, SpellsActivity::class.java))
                    }
                    val onClickStaff = {
                        startActivity(Intent(this@MainActivity, StaffActivity::class.java))
                    }
                    ActionIcons(
                        modifier = Modifier.padding(bottom = 8.dp),
                        onClickSpell = onClickSpell,
                        onClickStaff = onClickStaff
                    )

                    LazyVerticalGrid(
                        modifier = Modifier,
                        columns = GridCells.Fixed(count = 3),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                        items(character) { characters ->

                            Characters(character = characters) {
                                showDetail(characters)
                            }

                        }
                    }
                }
            }
        }
    }

    private fun showDetail(item: HarryPotterPresentation) {
        val detailBottomSheet = HarryPotterDetailBottomSheet(item)
        detailBottomSheet.show(supportFragmentManager, HarryPotterDetailBottomSheet.TAG)
    }

    @Composable
    fun ActionIcons(
        modifier: Modifier = Modifier,
        onClickSpell: () -> Unit,
        onClickStaff: () -> Unit,
    ) {
        Row(
            modifier = modifier.padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onClickStaff),
                painter = painterResource(id = R.drawable.staff),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(14.dp))
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onClickSpell),
                painter = painterResource(id = R.drawable.ic_spells),
                contentDescription = ""
            )
        }
    }
}