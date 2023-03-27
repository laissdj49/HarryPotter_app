package com.lais.harrypotter.spells.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.lais.harrypotter.R
import com.lais.harrypotter.databinding.ActivitySpellsBinding

class SpellsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpellsBinding
    private val viewModel: SpellsListViewModel by viewModels {SpellsListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpellsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}