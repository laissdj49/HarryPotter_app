package com.lais.harrypotter.characters.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import coil.compose.AsyncImage
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
            .inflate(R.layout.item_harry_potter_list, parent, false)
        return ViewHolder(view)
    }

    /**
     * Nos fornece o layout inflado associado a uma posicao da lista
     * similar ao onCriate, aqui podemos interagir com o layout e colocar minhas informacoes
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = list[position]
        holder.composeView.setContent {
            Characters(
                character = character,
                onClick = { onClick(character) })
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
fun Characters(
    character: HarryPotterPresentation,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .padding(16.dp)
                    .size(80.dp)
                    .clip(CircleShape),
                model = character.imageUrl,
                contentDescription = null,
            )
            if (character.house.icon != null) {
                Image(
                    modifier = Modifier
                        .padding(start = 24.dp, bottom = 16.dp)
                        .size(20.dp)
                        .align(Alignment.BottomStart),
                    painter = painterResource(id = character.house.icon),
                    contentDescription = ""
                )
            }
        }
        Text(
            modifier = Modifier.padding(bottom = 16.dp, start = 8.dp, end = 8.dp),
            text = character.name,
            color = colorResource(id = R.color.white ),
            textAlign = TextAlign.Center
        )
    }
}