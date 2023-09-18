package com.lais.harrypotter.characters.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.GridLayoutManager
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import com.lais.harrypotter.databinding.ActivityMainBinding
import com.lais.harrypotter.spells.view.SpellsActivity
import com.lais.harrypotter.staff.view.StaffActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HarryPotterListViewModel by viewModels { HarryPotterListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.compose.setContent {
            ActionIcons(
                onClickSpell = {
                    startActivity(Intent(this@MainActivity, SpellsActivity::class.java))

                },
                onClickStaff = {
                    startActivity(Intent(this@MainActivity, StaffActivity::class.java))

                }
            )
        }
        binding.list.layoutManager = GridLayoutManager(this, 3)

        viewModel.listCharacters.observe(this) {
            val harryPotterAdapter = HarryPotterAdapter(
                list = it,
                onClick = ::showDetail
            )
            binding.list.adapter = harryPotterAdapter
        }
        viewModel.listCharacters()
    }

    private fun showDetail(item: HarryPotterPresentation) {
        val detailBottomSheet = HarryPotterDetailBottomSheet(item)
        detailBottomSheet.show(supportFragmentManager, HarryPotterDetailBottomSheet.TAG)
    }

    @Composable
    fun ActionIcons(
        onClickSpell: () -> Unit,
        onClickStaff: () -> Unit,
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
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