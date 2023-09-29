package com.lais.harrypotter.spells.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import com.lais.harrypotter.R
import com.lais.harrypotter.spells.data.response.SpellsResponse

class SpellsAdapter(private val list: List<SpellsResponse>) :
    RecyclerView.Adapter<SpellsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val composeView: ComposeView

        init {
            composeView = view.findViewById(R.id.compose)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_spells_list,
                    parent,
                    false
                )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spell = list[position]
        holder.composeView.setContent {
            Spell(
                spell = spell
            )
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

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
