package com.lais.harrypotter.staff.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
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
        binding.imageStaff.load(staff.imageUrl)
        binding.textStringAncestry.text
        binding.textStringHouse.text
        binding.textStringYear.text
        binding.textStringPatronus.text
        binding.textStringWand.text
        binding.textName.text = staff.name
        binding.textAncestry.text = staff.ancestry.toString()
        binding.textHouse.text = staff.house.toString()
        binding.textYearbirth.text = staff.yearOfBirth.toString()
        binding.textWand.text = staff.wand.core
        binding.textPatronus.text = staff.patronus

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "HarryPotterDetailBottomSheet"
    }
}