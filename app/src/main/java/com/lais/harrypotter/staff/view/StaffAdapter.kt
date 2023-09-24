package com.lais.harrypotter.staff.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import coil.compose.AsyncImage
import com.lais.harrypotter.R
import com.lais.harrypotter.staff.domain.StaffPresentation

class StaffAdapter(
    private val list: List<StaffPresentation>,
    val onClick: (StaffPresentation) -> Unit,
) : RecyclerView.Adapter<StaffAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val composeView: ComposeView

        init {
            composeView = view.findViewById(R.id.compose)
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
        holder.composeView.setContent {
            Staff(
                staff = staff,
                onClick = { onClick(staff) })

        }
    }

    /**
     * Diz para a RecyclerView quantos itens teremos em nossa lista
     */

    override fun getItemCount(): Int {
        return list.size
    }
}

@Composable
fun Staff(
    staff: StaffPresentation,
    onClick: () -> Unit
) {

    Box {

        AsyncImage(
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxSize(),
            model = staff.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.White)
                .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp),
            text = staff.name,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

    }
}


