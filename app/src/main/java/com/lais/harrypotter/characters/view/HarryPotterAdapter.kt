package com.lais.harrypotter.characters.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation

/**
 * O adapter pega as informações do meu layout e adapta para a recyclerView criar a lista
 */

class HarryPotterAdapter(
    private val list: List<HarryPotterPresentation>,
    private val onClick: (HarryPotterPresentation) -> Unit,
) : RecyclerView.Adapter<HarryPotterAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameStudent: TextView
        val imageStudent: ImageView
        val houseImage: ImageView

        init {
            nameStudent = view.findViewById(R.id.name_student)
            imageStudent = view.findViewById(R.id.image_student)
            houseImage = view.findViewById(R.id.image_house)
        }
    }

    /**
     * Diz qual layout eu devo utilizar na minha lista e infla(cria) o layout escolhido
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_harry_potter_list, parent, false)
        return ViewHolder(view)
    }

    /**
     * Nos fornece o layout inflado associado a uma posicao da lista
     * similar ao onCriate, aqui podemos interagir com o layout e colocar minhas informacoes
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = list[position]
        holder.nameStudent.text = character.name

        if (character.house.icon != null) {
            val icon = ContextCompat.getDrawable(holder.itemView.context, character.house.icon)
            holder.houseImage.setImageDrawable(icon)
        }
        holder.imageStudent.load(character.imageUrl) {
            transformations(CircleCropTransformation())
        }
        holder.itemView.setOnClickListener {
            onClick.invoke(character)
        }
    }

    /**
     * Diz para a RecyclerView quantos itens teremos em nossa lista
     */
    override fun getItemCount(): Int {
        return list.size
    }
}