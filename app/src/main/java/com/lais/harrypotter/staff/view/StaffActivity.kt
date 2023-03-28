package com.lais.harrypotter.staff.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.lais.harrypotter.R
import com.lais.harrypotter.databinding.ActivitySpellsBinding
import com.lais.harrypotter.databinding.ActivityStaffBinding

class StaffActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaffBinding
    private val viewModel: StaffListViewModel by viewModels { StaffListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = GridLayoutManager(this, 3)
        viewModel.liststaff.observe(this) {
            val staffAdapter = StaffAdapter(it)
            binding.list.adapter = staffAdapter
        }
        viewModel.listStaff()
    }
}