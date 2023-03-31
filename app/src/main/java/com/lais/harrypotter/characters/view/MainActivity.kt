package com.lais.harrypotter.characters.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.lais.harrypotter.databinding.ActivityMainBinding
import com.lais.harrypotter.spells.view.SpellsActivity
import com.lais.harrypotter.staff.view.StaffActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HarryPotterListViewModel by viewModels { HarryPotterListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = GridLayoutManager(this, 3)
        viewModel.listCharacters.observe(this) {
            val harryPotterAdapter = HarryPotterAdapter(it)
            binding.list.adapter = harryPotterAdapter

        }
        viewModel.listCharacters()
        binding.buttonSpell.setOnClickListener {
            startActivity(Intent(this, SpellsActivity::class.java))
        }
        binding.buttonStaff.setOnClickListener {
            startActivity(Intent(this, StaffActivity::class.java))
        }





//        repository.getAllCharacters(object : CallBackListHarryPotter {
//            override fun onSuccess(list: List<HarryPotterCharactersResponse>) {
//                println(list)
//                binding.text.text = list.toString()
//            }
//
//            override fun onError(error: Throwable) {
//                error.printStackTrace()
//            }
//
//        })
//        lifecycleScope.launch {
//            try {
//                val result = repository.getCharacters()
//                binding.text.text = result.toString()
//            }catch (e: Throwable){
//                e.printStackTrace()
//            }
//        }
    }
}