package com.lais.harrypotter.spells.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lais.harrypotter.R
import com.lais.harrypotter.spells.data.response.SpellsResponse

class SpellsAdapter(private val list: List<SpellsResponse>) :
    RecyclerView.Adapter<SpellsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameSpell: TextView
        val description: TextView

        init {
            nameSpell = view.findViewById(R.id.name_spell)
            description = view.findViewById(R.id.description)
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
        holder.nameSpell.text = spell.name
        holder.description.text = spell.description

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

