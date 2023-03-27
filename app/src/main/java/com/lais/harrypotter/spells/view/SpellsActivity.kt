package com.lais.harrypotter.spells.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lais.harrypotter.R
import com.lais.harrypotter.databinding.ActivitySpellsBinding

class SpellsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpellsBinding
    private val viewModel: SpellsListViewModel by viewModels {SpellsListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpellsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = LinearLayoutManager(this)
        viewModel.listSpells.observe(this){
          val adapter = SpellsAdapter(it)
            binding.list.adapter = adapter
        }
        viewModel.listSpells()
    }
}