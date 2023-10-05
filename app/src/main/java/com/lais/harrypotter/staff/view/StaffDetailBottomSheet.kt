package com.lais.harrypotter.staff.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
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
import com.lais.harrypotter.databinding.DetailStaffBottomSheetBinding
import com.lais.harrypotter.staff.domain.StaffPresentation

class StaffDetailBottomSheet(
    val staff: StaffPresentation
) : BottomSheetDialogFragment() {
    private var _binding: DetailStaffBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

        ): View {
        _binding = DetailStaffBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomSheetStaff.setContent {
            StaffDetailsCompose(staff = staff)
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
fun StaffDetailsCompose(staff: StaffPresentation) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier.clip(shape = CircleShape),
            model = staff.imageUrl,
            contentDescription = null
        )
        Text(
            text = staff.name,
            color = colorResource(id = R.color.white),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        Column(modifier = Modifier.align(Alignment.Start)) {


            Text(
                text = stringResource(id = R.string.ancestryy),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white)
            )

            Text(
                modifier = Modifier.padding(2.dp),
                text = staff.ancestry.name,
                color = colorResource(id = R.color.white)
            )

            Text(
                text = stringResource(id = R.string.yearofbirth),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white)
            )
            //Box(modifier = Modifier.size(20.dp).clip(CircleShape).background(Color.Black))
            Text(
                modifier = Modifier.padding(2.dp),
                text = staff.yearOfBirth.toString(),
                color = colorResource(id = R.color.white)
            )

            Text(
                text = stringResource(id = R.string.house),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white)
            )

            Text(
                modifier = Modifier.padding(2.dp),
                text = staff.house.name,
                color = colorResource(id = R.color.white)
            )

            Text(
                text = stringResource(id = R.string.string_patronus),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white)
            )

            Text(
                modifier = Modifier.padding(2.dp),
                text = staff.patronus,
                color = colorResource(id = R.color.white)

            )

            Text(
                text = stringResource(id = R.string.wand),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white)
            )

            Text(
                modifier = Modifier.padding(2.dp),
                text = staff.wand.core,
                color = colorResource(id = R.color.white)
            )


        }
    }
}




