package com.lais.harrypotter.staff.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lais.harrypotter.R
import com.lais.harrypotter.staff.domain.StaffPresentation

class StaffAdapter(
    private val list: List<StaffPresentation>,
    val onClick: (StaffPresentation) -> Unit,
) : RecyclerView.Adapter<StaffAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameStaff: TextView
        val imageStaff: ImageView
        val ancestry: TextView

        init {
            nameStaff = view.findViewById(R.id.name_staff)
            imageStaff = view.findViewById(R.id.image_staff)
            ancestry = view.findViewById(R.id.ancestry)
        }

    }

    /**
     * Diz qual layout eu devo utilizar na minha lista e infla(cria) o layout escolhido
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staff_list, parent, false)
        return ViewHolder(view)
    }

    /**
     * Nos fornece o layout inflado associado a uma posicao da lista
     * similar ao onCriate, aqui podemos interagir com o layout e colocar nossas informacoes
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val staff = list[position]
        holder.nameStaff.text = staff.name
        holder.imageStaff.load(staff.imageUrl)
        holder.ancestry.text = staff.ancestry.toString()
        holder.itemView.setOnClickListener {
            onClick.invoke(staff)
        }
    }

    /**
     * Diz para a RecyclerView quantos itens teremos em nossa lista
     */

    override fun getItemCount(): Int {
        return list.size
    }

}

