package com.lais.harrypotter.characters.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
        binding.list.layoutManager = GridLayoutManager(this, 3)

        viewModel.listCharacters.observe(this) {
            val harryPotterAdapter = HarryPotterAdapter(
                list = it,
                onClick = ::showDetail
            )
            binding.list.adapter = harryPotterAdapter
        }
        viewModel.listCharacters()
        binding.buttonSpell.setOnClickListener {
            startActivity(Intent(this, SpellsActivity::class.java))
        }
        binding.buttonStaff.setOnClickListener {
            startActivity(Intent(this, StaffActivity::class.java))
        }
    }

    private fun showDetail(item: HarryPotterPresentation) {
        val detailBottomSheet = HarryPotterDetailBottomSheet(item)
        detailBottomSheet.show(supportFragmentManager, HarryPotterDetailBottomSheet.TAG)
    }
}