package com.lais.harrypotter.staff.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.lais.harrypotter.databinding.ActivityStaffBinding
import com.lais.harrypotter.staff.domain.StaffPresentation

class StaffActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaffBinding
    private val viewModel: StaffListViewModel by viewModels { StaffListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = GridLayoutManager(this, 3)
        viewModel.liststaff.observe(this) {
            val staffAdapter = StaffAdapter(
                list = it,
                onClick = ::showDetail
            )
            binding.list.adapter = staffAdapter
        }
        viewModel.listStaff()
    }

    private fun showDetail(item: StaffPresentation) {
        val detailBottomSheet = StaffDetailBottomSheet(item)
        detailBottomSheet.show(supportFragmentManager, StaffDetailBottomSheet.TAG)
    }
}