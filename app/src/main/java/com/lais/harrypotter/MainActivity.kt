package com.lais.harrypotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lais.harrypotter.data.CallBackListHarryPotter
import com.lais.harrypotter.data.HarryPotterRepository
import com.lais.harrypotter.data.HarryPotterService
import com.lais.harrypotter.data.RetrofitAPI
import com.lais.harrypotter.data.response.HarryPotterCharactersResponse
import com.lais.harrypotter.databinding.ActivityMainBinding
import com.lais.harrypotter.view.HarryPotterAdapter
import com.lais.harrypotter.view.HarryPotterListViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HarryPotterListViewModel by viewModels { HarryPotterListViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = GridLayoutManager(this, 3)
        viewModel.listCharacters.observe(this){
            val harryPotterAdapter = HarryPotterAdapter(it)
            binding.list.adapter = harryPotterAdapter
        }
        viewModel.listCharacters()








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