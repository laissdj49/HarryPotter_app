package com.lais.harrypotter.characters.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import com.lais.harrypotter.databinding.DetailHarryPotterBottomSheetBinding

class HarryPotterDetailBottomSheet(
    val character: HarryPotterPresentation
) : BottomSheetDialogFragment() {

    private var _binding: DetailHarryPotterBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailHarryPotterBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* binding.imageStudent.load(character.imageUrl)
         binding.textName.text = character.name
         binding.textAncestry.text = character.ancestry.toString()
         binding.textYearbirth.text = character.yearOfBirth.toString()
         binding.textHouse.text = character.house.toString()
         binding.textPatronus.text = character.patronus
         binding.textWand.text = character.wand.core*/
        binding.bottomSheetHarryPotter.setContent {
            HarryPotterDetailCompose(harryPotterDetail = character)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "HarryPotterDetailBottomSheet"
    }


}

@Composable
fun HarryPotterDetailCompose(harryPotterDetail: HarryPotterPresentation) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier.clip(shape = CircleShape).size(250.dp),
            model = harryPotterDetail.imageUrl,
            contentDescription = null
        )

        Text(
            text = harryPotterDetail.name,
            color = colorResource(id = R.color.white),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        Column(modifier = Modifier.align(Alignment.Start)) {

                Text(
                    text = stringResource(id = R.string.ancestryy),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.ancestry.name,
                    color = colorResource(id = R.color.white),
                )
                Text(
                    text = stringResource(id = R.string.yearofbirth),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.yearOfBirth.toString(),
                    color = colorResource(id = R.color.white)
                )
                Text(
                    text = stringResource(id = R.string.house),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.house.name,
                    color = colorResource(id = R.color.white)
                )
            if (harryPotterDetail.patronus.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.patronus),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.patronus,
                    color = colorResource(id = R.color.white)
                )
            }
            if (harryPotterDetail.wand.core.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.wand),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.white)
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = harryPotterDetail.wand.core,
                    color = colorResource(id = R.color.white),
                )
            }
        }
    }
}