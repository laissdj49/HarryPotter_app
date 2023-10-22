package com.lais.harrypotter.staff.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
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
import com.lais.harrypotter.utils.ColorApp

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
            StaffDetails(staff = staff)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}

@Composable
fun StaffDetails(staff: StaffPresentation) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(250.dp),
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
            if (staff.wand.core.isNotEmpty()) {
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
            }
            if (staff.wand.core.isNotEmpty()) {
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
        Spacer(modifier = Modifier.size(50.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffDetailBottomSheetCompose(
    staff: StaffPresentation,
    state: SheetState,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = state,
        containerColor = ColorApp.backgroundGray
    ) {
        StaffDetails(staff = staff)
    }
}




