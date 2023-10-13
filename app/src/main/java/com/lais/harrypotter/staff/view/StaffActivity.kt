package com.lais.harrypotter.staff.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.lais.harrypotter.staff.domain.StaffPresentation

class StaffActivity : AppCompatActivity() {

    private val viewModel: StaffListViewModel by viewModels { StaffListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.listStaff()
            val staffs by viewModel.liststaff.observeAsState(initial = emptyList())

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 3),
                contentPadding = PaddingValues(20.dp, 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                items(staffs) { staff ->
                    Staff(staff = staff) {
                        showDetail(staff)
                    }
                }

            }

        }
    }

    private fun showDetail(item: StaffPresentation) {
        val detailBottomSheet = StaffDetailBottomSheet(item)
        detailBottomSheet.show(supportFragmentManager, StaffDetailBottomSheet.TAG)
    }
}