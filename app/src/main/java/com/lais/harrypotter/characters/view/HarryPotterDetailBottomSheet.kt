package com.lais.harrypotter.characters.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lais.harrypotter.characters.domain.HarryPotterPresentation
import com.lais.harrypotter.databinding.DetailHarryPotterBottomSheetBinding

class HarryPotterDetailBottomSheet(
    val character: HarryPotterPresentation) : BottomSheetDialogFragment() {

    private var _binding: DetailHarryPotterBottomSheetBinding ?=null
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
        binding.imageStudent.load(character.imageUrl)
        binding.textStringAncestry.text
        binding.textStringYear.text
        binding.textStringHouse.text
        binding.textPatronus.text
        binding.textStringWand.text
        binding.textName.text = character.name
        binding.textAncestry.text = character.ancestry.toString()
        binding.textYearbirth.text = character.yearOfBirth.toString()
        binding.textHouse.text = character.house.toString()
        binding.textPatronus.text = character.patronus
        binding.textWand.text = character.wand.core
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "HarryPotterDetailBottomSheet"
    }


}