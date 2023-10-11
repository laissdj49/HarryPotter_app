package com.lais.harrypotter.spells.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class SpellsActivity : ComponentActivity() {

    private val viewModel: SpellsListViewModel by viewModels { SpellsListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.listSpells()
            val spells by viewModel.listSpells.observeAsState(initial = emptyList())
            LazyColumn {
                items(spells) { spell ->
                    Spell(spell = spell)
                }
            }
        }
    }
}